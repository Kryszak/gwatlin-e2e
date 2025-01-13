plugins {
    kotlin("jvm") version "2.1.0"
    id("com.adarshr.test-logger") version "4.0.0"
}

group = "io.github.kryszak"
version = "0.0.1"

repositories {
    mavenCentral()
    mavenLocal()
}

val gwatlinVersion = "2.2.5"
val kotestVersion = "5.9.1"

dependencies {
    implementation("io.github.kryszak:gwatlin:$gwatlinVersion")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}