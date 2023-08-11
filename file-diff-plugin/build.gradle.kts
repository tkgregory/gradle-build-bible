plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "com.gradlehero"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("fileDiff") {
            id = "com.gradlehero.file-diff"
            implementationClass = "com.gradlehero.FileDiffPlugin"
        }
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }
}