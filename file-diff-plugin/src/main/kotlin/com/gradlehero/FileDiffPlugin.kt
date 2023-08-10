package com.gradlehero

import org.gradle.api.Plugin
import org.gradle.api.Project

class FileDiffPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create("fileDiff", FileDiffPluginExtension::class.java)

        project.tasks.register("fileDiff", FileDiffTask::class.java) {
            file1.set(extension.file1)
            file2.set(extension.file2)
        }
    }
}