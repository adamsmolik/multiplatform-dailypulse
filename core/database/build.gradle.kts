plugins {
    id("plugin.dailypulse.kotlin.android")
    id("plugin.dailypulse.multiplatform")

    alias(libs.plugins.sqlDelight)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.sql.coroutines.extensions)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.sql.android.driver)
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

android { namespace = "com.adamsmolik.dailypulse.db" }

sqldelight {
    databases {
        create(name = "DailyPulseDatabase") {
            packageName.set("com.adamsmolik.dailypulse.core.db")
        }
    }
}
