plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
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