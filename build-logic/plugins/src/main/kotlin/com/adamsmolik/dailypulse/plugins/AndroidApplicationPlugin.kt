package com.adamsmolik.dailypulse.plugins

import com.android.build.api.dsl.ApplicationExtension
import com.adamsmolik.dailypulse.extensions.FlavorDimension
import com.adamsmolik.dailypulse.extensions.DailyPulseFlavor
import com.adamsmolik.dailypulse.extensions.Versions
import com.adamsmolik.dailypulse.extensions.configureAndroid
import com.adamsmolik.dailypulse.extensions.configureAndroidCompose
import com.adamsmolik.dailypulse.extensions.configureFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = Versions.TARGET_SDK
                    missingDimensionStrategy(
                        FlavorDimension.contentType.name,
                        DailyPulseFlavor.demo.name
                    )
                }

                buildFeatures {
                    buildConfig = true
                }

                configureAndroid()
                configureAndroidCompose(this)
                configureFlavors(this)
            }
        }
    }
}
