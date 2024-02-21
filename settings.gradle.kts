enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DailyPulse"

include(
    ":androidApp",
    ":core:base",
    ":core:database",
    ":core:network",
    ":core:ui",
    ":data:article",
    ":data:source",
    ":domain:article",
    ":domain:source",
    ":presentation:article",
    ":presentation:source",
    ":shared"
)
