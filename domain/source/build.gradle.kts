plugins {
    id("plugin.dailypulse.multiplatform")
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
