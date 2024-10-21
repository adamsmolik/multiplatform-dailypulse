import com.adamsmolik.dailypulse.extensions.DailyPulseBuildType

plugins {
    alias(libs.plugins.dailypulse.android.application)
}

android {
    namespace = "com.adamsmolik.dailypulse"

    defaultConfig {
        applicationId = "com.adamsmolik.dailypulse"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes { debug { applicationIdSuffix = DailyPulseBuildType.DEBUG.applicationIdSuffix } }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("/META-INF/versions/9/previous-compilation-data.bin")
        }
    }
}

dependencies {
    implementation(projects.shared)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    implementation(libs.coil.compose)

    implementation(libs.accompanist.swiperefresh)

    debugImplementation(libs.androidx.compose.ui.tooling)
}
