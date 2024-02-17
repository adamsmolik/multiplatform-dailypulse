enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("tooling")

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
    ":data:article",
    ":domain:article",
    ":shared"
)
