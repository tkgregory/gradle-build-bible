import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    base
}

val generateDescriptions = tasks.register<Copy>("generateDescriptions") {
    from("descriptions")
    into("$buildDir/descriptions")
    filter<ReplaceTokens>("tokens" to mapOf("THEME_PARK_NAME" to "Grelephant's Wonder World"))
}

tasks.register<Zip>("zipDescriptions") {
    from(generateDescriptions)
    destinationDirectory.set(buildDir)
    archiveFileName.set("descriptions.zip")
}