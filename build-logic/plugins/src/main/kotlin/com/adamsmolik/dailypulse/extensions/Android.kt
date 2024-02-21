package com.adamsmolik.dailypulse.extensions

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.configureAndroid() {
    android {
        compileSdkVersion(Versions.COMPILE_SDK)

        defaultConfig {
            minSdk = Versions.MIN_SDK
            targetSdk = Versions.TARGET_SDK
//          manifestPlaceholders[""] = ""
        }

//        compileOptions {
//            isCoreLibraryDesugaringEnabled = true
//        }

        packagingOptions {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }

//    dependencies {
//        "coreLibraryDesugaring"(libs.findLibrary("android.desugarJdkLibs").get())
//    }
}

fun Project.android(action: BaseExtension.() -> Unit) = extensions.configure<BaseExtension>(action)
