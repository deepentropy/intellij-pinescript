plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.10.4"
}

group = "io.github.houseofai"
version = "1.0.1"

repositories {
    mavenCentral()
    gradlePluginPortal()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2024.1.7")
        bundledPlugins("com.intellij.java")
    }
}

intellijPlatform {
    pluginConfiguration {
        id = "io.github.houseofai.pinescript"
        name = "PineScript v6 Language Support"
        version = "1.0.1"

        ideaVersion {
            sinceBuild = "231"
            untilBuild = "253.*"
        }
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    // Set the JDK version
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    // Disable instrumentation due to JDK path issues
    // The plugin will work without it for development purposes
    instrumentCode {
        enabled = false
    }
}
