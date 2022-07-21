import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    jacoco
    `java-library`
    `maven-publish`
}
group = "org.AdorableParker"
version = "0.1.0"


publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/AdorableParker/NekoEncode")
            credentials {
                username = project.findProperty("NekoEncode.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("NekoEncode.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
        publications {
            register<MavenPublication>("NekoEncode") {
                from(components["java"])
            }
        }

    }
}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}