import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    base
}

tasks.register<Copy>("generateDescriptions") {
    from("descriptions")
    into(layout.buildDirectory.dir("descriptions"))
    filter<ReplaceTokens>("tokens" to mapOf("THEME_PARK_NAME" to "Grelephant's Wonder World"))
}