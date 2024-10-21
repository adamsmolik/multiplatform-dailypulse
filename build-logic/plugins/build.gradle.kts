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
    compileOnly(libs.ktlint.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kotlinMultiplatform") {
            id = "dailypulse.kotlin.multiplatform"
            implementationClass = "com.adamsmolik.dailypulse.plugins.KotlinMultiplatformPlugin"
        }
        register("androidApplication") {
            id = "dailypulse.android.application"
            implementationClass = "com.adamsmolik.dailypulse.plugins.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "dailypulse.android.library"
            implementationClass = "com.adamsmolik.dailypulse.plugins.AndroidLibraryPlugin"
        }
        register("androidKotlin") {
            id = "dailypulse.android.kotlin"
            implementationClass = "com.adamsmolik.dailypulse.plugins.AndroidKotlinPlugin"
        }
        register("androidLibraryCompose") {
            id = "dailypulse.android.library.compose"
            implementationClass = "com.adamsmolik.dailypulse.plugins.AndroidLibraryComposePlugin"
        }
    }
}
