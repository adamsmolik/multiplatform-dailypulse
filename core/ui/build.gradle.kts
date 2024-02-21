plugins {
    alias(libs.plugins.dailypulse.android.kotlin)
    alias(libs.plugins.dailypulse.kotlin.multiplatform)
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
