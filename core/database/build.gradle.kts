plugins {
    alias(libs.plugins.dailypulse.android.kotlin)
    alias(libs.plugins.dailypulse.kotlin.multiplatform)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.sql.coroutines.extensions)
                implementation(libs.koin.core)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.sql.android.driver)
                implementation(libs.koin.android)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.sql.native.driver)

                // TODO check
                // See https://github.com/cashapp/sqldelight/issues/4357
//        implementation("co.touchlab:stately-common:2.0.6")
//        implementation("co.touchlab:stately-isolate:2.0.6")
//        implementation("co.touchlab:stately-iso-collections:2.0.6")
            }
        }
    }
}

android { namespace = "com.adamsmolik.dailypulse.core.db" }

sqldelight {
    databases {
        create(name = "DailyPulseDatabase") {
            packageName.set("com.adamsmolik.dailypulse.core.db")
        }
    }
}
