package com.adamsmolik.dailypulse.extensions

import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureDetekt() {
    extensions.configure<DetektExtension> {
        buildUponDefaultConfig = true
        parallel = true

        config.from("${project.rootDir}/detekt.yml")
    }
}
