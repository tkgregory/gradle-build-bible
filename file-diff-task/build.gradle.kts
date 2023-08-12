import com.gradlehero.FileDiffTask

tasks.register<FileDiffTask>("fileDiff") {
    file1.set(file("rollercoaster.jpg"))
    file2.set(file("logflume.jpg"))
}