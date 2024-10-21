package com.adamsmolik.dailypulse.extensions

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.KtlintExtension

internal fun Project.configureKtlint() = extensions.configure<KtlintExtension> {
    debug.set(false)
    verbose.set(false)
    android.set(true)

    filter {
        exclude("**/generated/**")
        include("**/java/**")
        include("**/kotlin/**")
    }
}
