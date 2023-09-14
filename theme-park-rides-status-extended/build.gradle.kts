plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "com.gradlehero.themepark.RideStatusService"
    }
}

application {
    mainClass.set("com.gradlehero.themepark.RideStatusService")
}

tasks.register<JavaExec>("runJar") {
    classpath(tasks.named("jar").map { it.outputs })
    classpath(configurations.runtimeClasspath)
    args(" teacups")
    mainClass.set("com.gradlehero.themepark.RideStatusService")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
        register<JvmTestSuite>("integrationTest") {
            dependencies {
                implementation(project())
            }
        }
    }
}

tasks.named("check") {
    dependsOn(tasks.named("integrationTest"))
}