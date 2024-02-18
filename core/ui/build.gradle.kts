plugins {
    id("plugin.dailypulse.kotlin.android")
    id("plugin.dailypulse.multiplatform")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
        }

        androidMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
        }
    }
}

android {
    namespace = "com.adamsmolik.dailypulse.core.ui"
}
