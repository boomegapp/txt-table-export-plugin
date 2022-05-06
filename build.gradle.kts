import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "com.dansoftware"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

javafx {
    version = "18"
    modules = listOf("javafx.controls")
}

val includeInJar = configurations.create("includeInJar")

dependencies {
    includeInJar("com.github.inamik.text.tables:inamik-text-tables:1.0-SNAPSHOT")
    implementation(fileTree(baseDir="lib"))
    testImplementation(kotlin("test"))

    configurations.implementation.get().extendsFrom(includeInJar)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

tasks.withType<Jar> {
    from(includeInJar.map { if(it.isDirectory) it else zipTree(it) })
}