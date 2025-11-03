plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("org.jetbrains.intellij.platform") version "2.1.0"
}

group = "com.tradingview"
version = "1.0.1"

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
        name = "PineScript Language Support"
        version = "1.0.1"
        description = "Language support for TradingView's PineScript v5"

        ideaVersion {
            sinceBuild = "231"
            untilBuild = "241.*"
        }

        changeNotes = """
            <h2>Version 1.0.1</h2>
            <ul>
                <li>Fixed critical lexer token boundary tracking bug</li>
                <li>Added support for PineScript v5 keywords (type, const, method)</li>
                <li>Improved syntax highlighting</li>
            </ul>
            <h2>Version 1.0.0</h2>
            <ul>
                <li>Syntax highlighting for PineScript v5</li>
                <li>Code completion for built-in functions</li>
                <li>Support for technical analysis functions</li>
                <li>Smart completions for indicator() and strategy() declarations</li>
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