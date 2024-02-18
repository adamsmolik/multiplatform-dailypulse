package com.adamsmolik.dailypulse.presentation.source.model

import com.adamsmolik.dailypulse.domain.source.model.SourceModel

data class SourceUiModel(
    val id: String,
    val name: String,
    val desc: String,
    val origin: String,
)

data class SourcesUiModel(
    val sources: List<SourceUiModel> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)

fun SourceModel.toUiModel() = SourceUiModel(
    id = id,
    name = name,
    desc = desc,
    origin = "$country - $language",
)
