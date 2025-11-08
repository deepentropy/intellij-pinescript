package io.github.houseofai.pinescript.parameterinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Pine Script function signature with its parameters.
 */
public class PineScriptFunctionSignature {
    private final String functionName;
    private final List<Parameter> parameters;

    public PineScriptFunctionSignature(String functionName, Parameter... parameters) {
        this.functionName = functionName;
        this.parameters = Arrays.asList(parameters);
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public String getParameterText(int index) {
        if (index < 0 || index >= parameters.size()) {
            return "";
        }
        Parameter param = parameters.get(index);
        return param.toString();
    }

    public int getParameterCount() {
        return parameters.size();
    }

    /**
     * Represents a single function parameter.
     */
    public static class Parameter {
        private final String name;
        private final String type;
        private final String defaultValue;
        private final boolean optional;

        public Parameter(String name, String type) {
            this(name, type, null, false);
        }

        public Parameter(String name, String type, String defaultValue) {
            this(name, type, defaultValue, true);
        }

        public Parameter(String name, String type, String defaultValue, boolean optional) {
            this.name = name;
            this.type = type;
            this.defaultValue = defaultValue;
            this.optional = optional;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public boolean isOptional() {
            return optional;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            if (type != null && !type.isEmpty()) {
                sb.append(": ").append(type);
            }
            if (defaultValue != null) {
                sb.append(" = ").append(defaultValue);
            }
            return sb.toString();
        }
    }
}
