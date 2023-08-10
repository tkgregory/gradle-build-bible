plugins {
    id("com.gradlehero.themepark-conventions")
    `java-library`
}

tasks.named<Jar>("jar") {
    manifest {
        attributes["Main-Class"] = "com.gradlehero.themepark.RideStatusService"
    }
}