package com.adamsmolik.dailypulse.plugins

import com.android.build.gradle.LibraryExtension
import com.adamsmolik.dailypulse.extensions.Versions
import com.adamsmolik.dailypulse.extensions.configureKotlin
import com.adamsmolik.dailypulse.extensions.configureKtlint
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.library")
            apply("org.jlleitschuh.gradle.ktlint")
        }

        configureKotlin()
        configureKtlint()

        extensions.configure<LibraryExtension> {
            compileSdk = Versions.COMPILE_SDK
        }
    }
}
