import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    base
}

tasks.register<Copy>("generateDescriptions") {
    from("descriptions")
    into("$buildDir/descriptions")
    filter<ReplaceTokens>("tokens" to mapOf("THEME_PARK_NAME" to "Grelephant's Wonder World"))
}

tasks.register<Zip>("zipDescriptions") {
    destinationDirectory.set(buildDir)
    archiveFileName.set("descriptions.zip")
    from("$buildDir/descriptions")
}