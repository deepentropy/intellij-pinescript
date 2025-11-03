plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.17.4"
}

group = "com.tradingview"
version = "1.0.0"

repositories {
    mavenCentral()
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
            <h2>Initial Release</h2>
            <ul>
                <li>Syntax highlighting for PineScript v5</li>
                <li>Code completion for built-in functions</li>
                <li>Support for technical analysis functions</li>
                <li>Smart completions for indicator() and strategy() declarations</li>
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