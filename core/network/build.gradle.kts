plugins {
    alias(libs.plugins.dailypulse.android.kotlin)
    alias(libs.plugins.dailypulse.kotlin.multiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core.base)

                implementation(libs.bundles.shared.ktor)
                implementation(libs.koin.core)
                implementation(libs.ktor.client.serialization)
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
