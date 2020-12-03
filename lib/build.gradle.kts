import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("kapt")
}

val vertxVersion = "4.0.0.CR2"
val mainVerticleName = "com.karen.Main"
val launcherClassName = "io.vertx.core.Launcher"
val doOnChange = "./gradlew classes"
val watchForChange = "src/**/*"

dependencies {
    kapt("io.vertx:vertx-codegen:$vertxVersion:processor")
    kapt("io.vertx:vertx-service-proxy:$vertxVersion")

    api("io.vertx:vertx-codegen:$vertxVersion")
    api("io.vertx:vertx-service-proxy:$vertxVersion")
    api("io.vertx:vertx-service-discovery:$vertxVersion")
    api("io.vertx:vertx-ignite:$vertxVersion")
    api("io.vertx:vertx-circuit-breaker:$vertxVersion")
    api("io.vertx:vertx-core:$vertxVersion")
    api("io.vertx:vertx-lang-kotlin:$vertxVersion")
    api("io.vertx:vertx-lang-kotlin-coroutines:$vertxVersion")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}