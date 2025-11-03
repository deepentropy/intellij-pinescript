plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.10.4"
}

group = "com.tradingview"
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
        instrumentationTools()
    }
}

// Configure Java compatibility
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

intellijPlatform {
    pluginConfiguration {
        id = "com.tradingview.pinescript"
        name = "PineScript"
        version = "1.0.0"
        description = "Professional PineScript language support with TradingView-accurate syntax highlighting"

        ideaVersion {
            sinceBuild = "231"
            untilBuild = "261.*"
        }

        changeNotes = """
            <h2>Version 1.0.0</h2>
            <ul>
                <li>Initial release with full PineScript v5 support</li>
                <li>TradingView-accurate syntax highlighting with correct colors</li>
                <li>Code completion for all major PineScript namespaces</li>
                <li>Support for indicator, strategy, and library declarations</li>
                <li>Built-in function recognition and highlighting</li>
                <li>Proper handling of ternary operators and special characters</li>
                <li>Disabled spell checking for PineScript keywords</li>
            </ul>
        """.trimIndent()
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
    }
}