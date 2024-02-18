// ktlint-disable filename

package com.adamsmolik.dailypulse.data.source.model

import com.adamsmolik.dailypulse.domain.source.model.SourceModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesDTO(
    @SerialName("status")
    val status: String,
    @SerialName("sources")
    val sources: List<SourceDTO>,
)

@Serializable
data class SourceDTO(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val desc: String,
    @SerialName("language")
    val language: String,
    @SerialName("country")
    val country: String,
)

fun SourceDTO.toModel() = SourceModel(
    id = id,
    name = name,
    desc = desc,
    language = language,
    country = country,
)
