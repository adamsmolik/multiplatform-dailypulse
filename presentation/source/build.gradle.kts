plugins {
    id("plugin.dailypulse.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core.ui)
                implementation(projects.domain.source)

                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.koin.core)
            }
        }
    }
}
