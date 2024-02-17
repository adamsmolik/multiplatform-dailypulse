plugins {
    id("plugin.dailypulse.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core.base)
            }
        }
    }
}
