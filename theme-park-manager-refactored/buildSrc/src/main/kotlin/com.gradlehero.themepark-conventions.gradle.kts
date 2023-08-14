plugins {
    `java`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}