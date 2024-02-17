import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("plugin.dailypulse.kotlin.android")
    id("plugin.dailypulse.multiplatform")

    alias(libs.plugins.sqlDelight)
    id("co.touchlab.skie") version "0.6.1"
    kotlin("plugin.serialization") version "1.9.20"
}

version = libs.versions.shared.module.version.get()

kotlin {
    sourceSets {
        targets.withType<KotlinNativeTarget>().configureEach {
            binaries.withType<Framework> {
                baseName = "shared"

                export(projects.core.database)

                export(projects.domain.article)
            }
        }

        commonMain.dependencies {
            api(projects.core.database)

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.bundles.shared.ktor)
            implementation(libs.koin.core)
        }

        androidMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.adamsmolik.dailypulse"
}
