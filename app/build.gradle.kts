import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("kapt")
    application
}

val mainVerticleName = "com.karen.MainVerticle"
val launcherClassName = "io.vertx.core.Launcher"
val doOnChange = "./gradlew classes"
val watchForChange = "src/**/*"

dependencies {
    implementation(project(":lib"))
}

application {
    mainClass.set(launcherClassName)
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<JavaExec> {
    args = listOf(
        "run",
        mainVerticleName,
        "--redeploy=$watchForChange",
        "--launcher-class=$launcherClassName",
        "--on-redeploy=$doOnChange",
//        "-conf=conf.json",
        "-cluster"
    )
}
