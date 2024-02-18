plugins {
    id("plugin.dailypulse.multiplatform")

    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core.database)
                implementation(projects.core.network)
                implementation(projects.domain.article)

                implementation(libs.koin.core)
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.serialization)
            }
        }
    }
}
