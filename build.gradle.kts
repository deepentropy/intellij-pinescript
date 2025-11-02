plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.16.0"
}

group = "com.tradingview"
version = "1.0.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    // No additional dependencies needed for basic plugin
}

intellij {
    version.set("2023.1.1")
    type.set("IC") // IntelliJ IDEA Community Edition
    // Plugins required by the plugin
    plugins.set(listOf())
}

tasks {
    // Set the JDK version
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    patchPluginXml {
        changeNotes.set("""
            <h2>Version 1.0.0 - PineScript v6 Support</h2>
            <ul>
                <li><strong>PineScript v6 Syntax:</strong> Full support for v6 features including type, enum, method, and switch keywords</li>
                <li><strong>User-Defined Types:</strong> Syntax highlighting and completion for custom types</li>
                <li><strong>Annotations:</strong> Special highlighting for @version, @type, @enum, @field, @function, @param, @returns, @variable, and @description</li>
                <li><strong>Expanded Completion:</strong> 500+ autocomplete items covering all major namespaces</li>
                <li><strong>New Collections:</strong> Support for map.* and matrix.* functions</li>
                <li><strong>Drawing Objects:</strong> Completion for polyline.* and linefill.* (v6 features)</li>
                <li><strong>Enhanced Arrays:</strong> Full array.* function library</li>
                <li><strong>Technical Analysis:</strong> Comprehensive ta.* function set with 50+ indicators</li>
            </ul>
        """.trimIndent())

        // IntelliJ builds
        sinceBuild.set("231")
        untilBuild.set("241.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}