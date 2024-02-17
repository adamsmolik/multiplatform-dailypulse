plugins {
    `kotlin-dsl`
}

group = "com.adamsmolik.dailypulse.plugins"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatformPlugin") {
            id = "plugin.dailypulse.multiplatform"
            implementationClass = "com.adamsmolik.dailypulse.plugins.KotlinMultiplatformConventionPlugin"
        }
        register("androidApplication") {
            id = "dailypulse.application"
            implementationClass = "com.adamsmolik.dailypulse.plugins.ApplicationPlugin"
        }
        register("androidLibrary") {
            id = "plugin.dailypulse.android.library"
            implementationClass = "com.adamsmolik.dailypulse.plugins.AndroidLibraryPlugin"
        }
        register("kotlinAndroid") {
            id = "plugin.dailypulse.kotlin.android"
            implementationClass = "com.adamsmolik.dailypulse.plugins.KotlinAndroidPlugin"
        }
        register("androidComposeLibrary") {
            id = "plugin.dailypulse.compose.library"
            implementationClass = "com.adamsmolik.dailypulse.plugins.ComposeLibraryPlugin"
        }
    }
}
