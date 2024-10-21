package com.adamsmolik.dailypulse.plugins

import com.android.build.gradle.LibraryExtension
import com.adamsmolik.dailypulse.extensions.Versions
import com.adamsmolik.dailypulse.extensions.configureAndroid
import com.adamsmolik.dailypulse.extensions.configureFlavors
import com.adamsmolik.dailypulse.extensions.configureKtlint
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.library")
            apply("org.jlleitschuh.gradle.ktlint")
        }

        configureKtlint()

        extensions.configure<LibraryExtension> {
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

            defaultConfig.targetSdk = Versions.TARGET_SDK

            configureAndroid()
            configureFlavors(this)
        }
    }
}
