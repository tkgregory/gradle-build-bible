package com.gradlehero

import org.gradle.api.file.RegularFileProperty

interface FileDiffPluginExtension {
    val file1: RegularFileProperty
    val file2: RegularFileProperty
}