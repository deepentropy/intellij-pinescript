package io.github.houseofai.pinescript.compiler;

import com.intellij.openapi.diagnostic.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Service for compiling PineScript code using TradingView's translate_light API.
 */
public class PineScriptCompilerService {
    private static final Logger LOG = Logger.getInstance(PineScriptCompilerService.class);

    private static final String API_URL = "https://pine-facade.tradingview.com/pine-facade/translate_light";
    private static final Duration TIMEOUT = Duration.ofSeconds(30);

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(TIMEOUT)
            .build();

    /**
     * Represents a compilation error or warning.
     */
    public static class CompilationIssue {
        public enum Severity { ERROR, WARNING }

        private final Severity severity;
        private final int line;
        private final int column;
        private final int endLine;
        private final int endColumn;
        private final String message;

        public CompilationIssue(Severity severity, int line, int column, int endLine, int endColumn, String message) {
            this.severity = severity;
            this.line = line;
            this.column = column;
            this.endLine = endLine;
            this.endColumn = endColumn;
            this.message = message;
        }

        public Severity getSeverity() { return severity; }
        public int getLine() { return line; }
        public int getColumn() { return column; }
        public int getEndLine() { return endLine; }
        public int getEndColumn() { return endColumn; }
        public String getMessage() { return message; }

        @Override
        public String toString() {
            return String.format("[%s] Line %d:%d - %s", severity, line, column, message);
        }
    }

    /**
     * Result of a compilation attempt.
     */
    public static class CompilationResult {
        private final boolean success;
        private final List<CompilationIssue> issues;
        private final String rawResponse;
        private final String error;

        private CompilationResult(boolean success, List<CompilationIssue> issues, String rawResponse, String error) {
            this.success = success;
            this.issues = issues;
            this.rawResponse = rawResponse;
            this.error = error;
        }

        public static CompilationResult success(List<CompilationIssue> issues, String rawResponse) {
            return new CompilationResult(true, issues, rawResponse, null);
        }

        public static CompilationResult failure(String error) {
            return new CompilationResult(false, new ArrayList<>(), null, error);
        }

        public boolean isSuccess() { return success; }
        public List<CompilationIssue> getIssues() { return issues; }
        public String getRawResponse() { return rawResponse; }
        public String getError() { return error; }

        public boolean hasErrors() {
            return issues.stream().anyMatch(i -> i.getSeverity() == CompilationIssue.Severity.ERROR);
        }

        public boolean hasWarnings() {
            return issues.stream().anyMatch(i -> i.getSeverity() == CompilationIssue.Severity.WARNING);
        }
    }

    /**
     * Compile PineScript code and return the result.
     *
     * @param code The PineScript source code to compile
     * @return CompilationResult with errors/warnings or success status
     */
    @NotNull
    public static CompilationResult compile(@NotNull String code) {
        try {
            // Build multipart form data
            String boundary = "----PineScriptBoundary" + System.currentTimeMillis();
            String body = buildMultipartBody(boundary, code);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL + "?user_name=guest&v=3"))
                    .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36")
                    .header("Accept", "*/*")
                    .header("Origin", "https://www.tradingview.com")
                    .header("Referer", "https://www.tradingview.com/")
                    .timeout(TIMEOUT)
                    .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                return CompilationResult.failure("HTTP " + response.statusCode() + ": " + response.body().substring(0, Math.min(200, response.body().length())));
            }

            return parseResponse(response.body());

        } catch (IOException e) {
            LOG.warn("Failed to compile PineScript: " + e.getMessage());
            return CompilationResult.failure("Network error: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return CompilationResult.failure("Request interrupted");
        } catch (Exception e) {
            LOG.error("Unexpected error during compilation", e);
            return CompilationResult.failure("Unexpected error: " + e.getMessage());
        }
    }

    /**
     * Build multipart form data body.
     */
    private static String buildMultipartBody(String boundary, String code) {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"source\"\r\n");
        sb.append("\r\n");
        sb.append(code);
        sb.append("\r\n");
        sb.append("--").append(boundary).append("--\r\n");
        return sb.toString();
    }

    /**
     * Parse the API response and extract errors/warnings.
     */
    private static CompilationResult parseResponse(String responseBody) {
        List<CompilationIssue> issues = new ArrayList<>();

        try {
            // Simple JSON parsing without external dependencies
            // Look for "errors" array
            issues.addAll(parseIssueArray(responseBody, "errors", CompilationIssue.Severity.ERROR));

            // Look for "warnings" array
            issues.addAll(parseIssueArray(responseBody, "warnings", CompilationIssue.Severity.WARNING));

            return CompilationResult.success(issues, responseBody);

        } catch (Exception e) {
            LOG.warn("Failed to parse compilation response: " + e.getMessage());
            return CompilationResult.failure("Failed to parse response: " + e.getMessage());
        }
    }

    /**
     * Parse an array of issues from the JSON response.
     */
    private static List<CompilationIssue> parseIssueArray(String json, String arrayName, CompilationIssue.Severity severity) {
        List<CompilationIssue> issues = new ArrayList<>();

        // Find the array in the response
        // Pattern: "errors": [...] or "warnings": [...]
        String pattern = "\"" + arrayName + "\"\\s*:\\s*\\[";
        int arrayStart = findPattern(json, pattern);
        if (arrayStart < 0) {
            return issues;
        }

        // Find the matching closing bracket
        int bracketCount = 1;
        int pos = arrayStart;
        int arrayEnd = -1;
        while (pos < json.length() && bracketCount > 0) {
            char c = json.charAt(pos);
            if (c == '[') bracketCount++;
            else if (c == ']') bracketCount--;
            if (bracketCount == 0) {
                arrayEnd = pos;
            }
            pos++;
        }

        if (arrayEnd < 0) {
            return issues;
        }

        String arrayContent = json.substring(arrayStart, arrayEnd);

        // Parse individual error/warning objects
        // Pattern for each issue: {"line":N,"column":N,"end_line":N,"end_column":N,"message":"..."}
        Pattern issuePattern = Pattern.compile(
            "\\{[^}]*\"line\"\\s*:\\s*(\\d+)[^}]*\"column\"\\s*:\\s*(\\d+)[^}]*" +
            "(?:\"end_line\"\\s*:\\s*(\\d+)[^}]*)?(?:\"end_column\"\\s*:\\s*(\\d+)[^}]*)?" +
            "\"message\"\\s*:\\s*\"([^\"]*(?:\\\\.[^\"]*)*)\"[^}]*\\}"
        );

        // Also try alternative pattern where message comes first
        Pattern altPattern = Pattern.compile(
            "\\{[^}]*\"message\"\\s*:\\s*\"([^\"]*(?:\\\\.[^\"]*)*)\"[^}]*" +
            "\"line\"\\s*:\\s*(\\d+)[^}]*\"column\"\\s*:\\s*(\\d+)[^}]*" +
            "(?:\"end_line\"\\s*:\\s*(\\d+)[^}]*)?(?:\"end_column\"\\s*:\\s*(\\d+)[^}]*)?\\}"
        );

        Matcher matcher = issuePattern.matcher(arrayContent);
        while (matcher.find()) {
            try {
                int line = Integer.parseInt(matcher.group(1));
                int column = Integer.parseInt(matcher.group(2));
                int endLine = matcher.group(3) != null ? Integer.parseInt(matcher.group(3)) : line;
                int endColumn = matcher.group(4) != null ? Integer.parseInt(matcher.group(4)) : column + 1;
                String message = unescapeJson(matcher.group(5));

                issues.add(new CompilationIssue(severity, line, column, endLine, endColumn, message));
            } catch (NumberFormatException e) {
                // Skip malformed entries
            }
        }

        // Try alternative pattern if no matches found
        if (issues.isEmpty()) {
            matcher = altPattern.matcher(arrayContent);
            while (matcher.find()) {
                try {
                    String message = unescapeJson(matcher.group(1));
                    int line = Integer.parseInt(matcher.group(2));
                    int column = Integer.parseInt(matcher.group(3));
                    int endLine = matcher.group(4) != null ? Integer.parseInt(matcher.group(4)) : line;
                    int endColumn = matcher.group(5) != null ? Integer.parseInt(matcher.group(5)) : column + 1;

                    issues.add(new CompilationIssue(severity, line, column, endLine, endColumn, message));
                } catch (NumberFormatException e) {
                    // Skip malformed entries
                }
            }
        }

        // Fallback: try to extract any line/column/message combination
        if (issues.isEmpty() && arrayContent.contains("\"line\"")) {
            Pattern simplePattern = Pattern.compile("\"line\"\\s*:\\s*(\\d+)");
            Pattern colPattern = Pattern.compile("\"column\"\\s*:\\s*(\\d+)");
            Pattern msgPattern = Pattern.compile("\"message\"\\s*:\\s*\"([^\"]+)\"");

            Matcher lineMatcher = simplePattern.matcher(arrayContent);
            Matcher colMatcher = colPattern.matcher(arrayContent);
            Matcher msgMatcher = msgPattern.matcher(arrayContent);

            while (lineMatcher.find() && colMatcher.find() && msgMatcher.find()) {
                int line = Integer.parseInt(lineMatcher.group(1));
                int column = Integer.parseInt(colMatcher.group(1));
                String message = unescapeJson(msgMatcher.group(1));
                issues.add(new CompilationIssue(severity, line, column, line, column + 1, message));
            }
        }

        return issues;
    }

    /**
     * Find pattern in string and return position after the match.
     */
    private static int findPattern(String str, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return m.end();
        }
        return -1;
    }

    /**
     * Unescape JSON string.
     */
    private static String unescapeJson(String str) {
        if (str == null) return "";
        return str
                .replace("\\n", "\n")
                .replace("\\r", "\r")
                .replace("\\t", "\t")
                .replace("\\\"", "\"")
                .replace("\\'", "'")
                .replace("\\\\", "\\");
    }
}
