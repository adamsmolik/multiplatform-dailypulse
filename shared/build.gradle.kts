import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.dailypulse.android.kotlin)
    alias(libs.plugins.dailypulse.kotlin.multiplatform)
    alias(libs.plugins.sqlDelight)
    alias(libs.plugins.skie)
}

version = libs.versions.shared.module.version.get()

kotlin {
    sourceSets {
        targets.withType<KotlinNativeTarget>().configureEach {
            binaries.withType<Framework> {
                baseName = "shared"

                export(projects.presentation.article)
                export(projects.presentation.source)
            }
        }

        commonMain.dependencies {
            api(projects.core.base)
            api(projects.core.database)
            api(projects.core.network)
            api(projects.core.ui)

            api(projects.data.article)
            api(projects.data.source)

            api(projects.domain.article)
            api(projects.domain.source)

            api(projects.presentation.article)
            api(projects.presentation.source)

            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.adamsmolik.dailypulse.shared"
}
