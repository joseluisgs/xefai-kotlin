import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

val xef_ai_version: String by project
val openAiToken: String by project


plugins {
    kotlin("jvm") version "1.9.0"
    application
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

group = "dev.joseluisgs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Xef
    implementation("com.xebia:xef-core:$xef_ai_version")
    implementation("com.xebia:xef-kotlin:$xef_ai_version")
    testImplementation(kotlin("test"))
}


tasks.test {
    useJUnitPlatform()
}

/*tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}*/

application {
    mainClass.set("MainKt")
}

// Para forzar la versión de kotlin a 1.9.0
kotlin {
    compilerOptions {
        languageVersion.set(KotlinVersion.KOTLIN_1_9)
        apiVersion.set(KotlinVersion.KOTLIN_1_9)
        jvmTarget.set(JvmTarget.JVM_11)
    } // Extension for easy setup
    jvmToolchain(11) // Target version of generated JVM bytecode
}

