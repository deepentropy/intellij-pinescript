plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.10.4"
}

group = "io.github.houseofai"
version = "1.0.0"

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2023.1.1")

        // Plugin development tools
        bundledPlugins("com.intellij.java")
    }
}

// Configure Java compatibility
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}

intellijPlatform {
    pluginConfiguration {
        id = "io.github.houseofai.pinescript"
        name = "Pine Script Support"
        version = "1.0.0"
        description = "Pine Script language support with syntax highlighting for IntelliJ-based IDEs"

        ideaVersion {
            sinceBuild = "231"
            untilBuild = "261.*"
        }

        changeNotes = """
            <h2>Version 1.0.0</h2>
            <ul>
                <li>Initial release with full Pine Script v6 support</li>
                <li>Syntax highlighting with appropriate colors</li>
                <li>Code completion for major Pine Script namespaces</li>
                <li>Support for indicator, strategy, and library declarations</li>
                <li>Built-in function recognition and highlighting</li>
                <li>Proper handling of ternary operators and special characters</li>
                <li>Disabled spell checking for Pine Script keywords</li>
            </ul>
        """.trimIndent()
    }

    instrumentCode = false

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
    }
}