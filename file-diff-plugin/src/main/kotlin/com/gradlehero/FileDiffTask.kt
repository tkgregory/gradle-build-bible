package com.gradlehero

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

abstract class FileDiffTask : DefaultTask() {
    @get:InputFile
    abstract val file1: RegularFileProperty
    @get:InputFile
    abstract val file2: RegularFileProperty

    @TaskAction
    fun diff() {
        val file1 = file1.get().asFile
        val file2 = file2.get().asFile
        if (file1.length() == file2.length()) {
            println("${file1.name} and ${file2.name} have the same size")
        } else if (file1.length() > file2.length()) {
            println("${file1.name} was larger")
        } else {
            println("${file2.name} was larger")
        }
    }
}