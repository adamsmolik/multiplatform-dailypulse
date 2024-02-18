plugins {
    id("plugin.dailypulse.kotlin.android")
    id("plugin.dailypulse.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.bundles.shared.ktor)
                implementation(libs.koin.core)
            }
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.adamsmolik.dailypulse.core.network"
}
