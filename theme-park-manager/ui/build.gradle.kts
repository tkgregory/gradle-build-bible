plugins {
    `java-library`
}

// the following generates downloadable files for lesson "Practical: creating a multi-project build" so can be ignored
tasks.register<Copy>("downloadable") {
    from(parent?.layout?.projectDirectory)
    include("${project.name}/build.gradle.kts")
    include("${project.name}/src/**")
    into(layout.buildDirectory.dir("course-downloadable"))
}

tasks.register<Zip>("downloadableZip") {
    from(parent?.layout?.projectDirectory)
    include("${project.name}/build.gradle.kts")
    include("${project.name}/src/**")
    archiveFileName.set("ui.zip")
    destinationDirectory.set(layout.buildDirectory)
}

tasks.named("assemble").configure {
    dependsOn(tasks.named("downloadable"), tasks.named("downloadableZip"))
}