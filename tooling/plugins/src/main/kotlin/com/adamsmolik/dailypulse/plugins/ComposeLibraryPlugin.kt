package com.adamsmolik.dailypulse.plugins

import com.android.build.gradle.LibraryExtension
import com.adamsmolik.dailypulse.extensions.Versions
import com.adamsmolik.dailypulse.extensions.configureAndroidCompose
import com.adamsmolik.dailypulse.extensions.configureFlavors
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ComposeLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                compileSdk = Versions.COMPILE_SDK

                configureAndroidCompose(this)
                configureFlavors(this)
            }
        }
    }
}
