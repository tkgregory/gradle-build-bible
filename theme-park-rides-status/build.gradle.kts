plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "com.gradlehero.themepark.RideStatusService"
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

application {
    mainClass.set("com.gradlehero.themepark.RideStatusService")
}

testing {
    suites {
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