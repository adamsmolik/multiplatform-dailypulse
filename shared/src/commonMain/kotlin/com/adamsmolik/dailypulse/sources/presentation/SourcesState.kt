package com.adamsmolik.dailypulse.sources.presentation

import com.adamsmolik.dailypulse.sources.application.Source

data class SourcesState (
    val sources: List<Source>,
    val loading: Boolean = false,
    val error: String? = null
)
