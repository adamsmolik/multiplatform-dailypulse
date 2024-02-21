plugins {
    alias(libs.plugins.dailypulse.kotlin.multiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(projects.core.base)
            }
        }
    }
}
