plugins {
    id("com.gradlehero.themepark-conventions")
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
}

dependencies {
    implementation(project(":service"))
    implementation(project(":ui"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}