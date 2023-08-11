package com.gradlehero

import org.gradle.internal.impldep.org.hamcrest.CoreMatchers.containsString
import org.gradle.internal.impldep.org.hamcrest.CoreMatchers.equalTo
import org.gradle.internal.impldep.org.hamcrest.MatcherAssert.assertThat
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

class FileDiffPluginFunctionalTest {
    @TempDir
    lateinit var tempFolder: File
    private lateinit var testFile1: File
    private lateinit var testFile2: File

    @BeforeEach
    fun setup() {
        testFile1 = File(tempFolder, "testFile1.txt")
        testFile2 = File(tempFolder, "testFile2.txt")

        val buildScript = File(tempFolder, "build.gradle.kts")
        buildScript.writeText(
                """
           import com.gradlehero.FileDiffPluginExtension         
                    
            plugins {
                id("com.gradlehero.file-diff")
            }
            
            configure<FileDiffPluginExtension> {
                file1.set(file("testFile1.txt"))
                file2.set(file("testFile2.txt"))
            }
            """.trimIndent()
        )
    }

    @Test
    fun `can diff 2 files of same length`() {
        testFile1.writeText("")
        testFile2.writeText("")

        val buildResult = executeBuild()

        assertThat(buildResult.output, containsString("testFile1.txt and testFile2.txt have the same size"))
        assertThat(buildResult.task(":fileDiff")?.outcome, equalTo(TaskOutcome.SUCCESS))
    }

    @Test
    fun `can diff 2 files where 1st file larger than 2nd`() {
        testFile1.writeText("Some text")
        testFile2.writeText("")

        val buildResult = executeBuild()

        assertThat(buildResult.output, containsString("testFile1.txt was larger"))
        assertThat(buildResult.task(":fileDiff")?.outcome, equalTo(TaskOutcome.SUCCESS))
    }

    @Test
    fun `can diff 2 files where 2nd file larger than 1st`() {
        testFile1.writeText("")
        testFile2.writeText("Some text")

        val buildResult = executeBuild()

        assertThat(buildResult.output, containsString("testFile2.txt was larger"))
        assertThat(buildResult.task(":fileDiff")?.outcome, equalTo(TaskOutcome.SUCCESS))
    }

    private fun executeBuild(): BuildResult {
        return GradleRunner.create()
                .withProjectDir(tempFolder)
                .withArguments("fileDiff")
                .withPluginClasspath()
                .build()
    }
}

