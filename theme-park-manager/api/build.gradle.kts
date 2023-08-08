plugins {
    java
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":service"))
    implementation(project(":ui"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}