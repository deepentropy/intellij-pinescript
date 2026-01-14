plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.10.4"
}

group = "io.github.houseofai"
version = "1.0.4"

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
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)
    }
    testImplementation("junit:junit:4.13.2")
}

intellijPlatform {
    pluginConfiguration {
        id = "io.github.houseofai.pinescript"
        name = "PineScript v6 Language Support"
        version = "1.0.4"

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
    // Use the current JDK instead of requiring toolchain
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
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
