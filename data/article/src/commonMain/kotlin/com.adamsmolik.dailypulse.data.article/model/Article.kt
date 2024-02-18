// ktlint-disable filename

package com.adamsmolik.dailypulse.data.article.model

import com.adamsmolik.dailypulse.domain.article.model.ArticleModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesDTO(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val results: Int,
    @SerialName("articles")
    val articles: List<ArticleDTO>,
)

@Serializable
data class ArticleDTO(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String?,
    @SerialName("publishedAt")
    val date: String,
    @SerialName("urlToImage")
    val imageUrl: String?,
)

fun ArticleDTO.toModel() = ArticleModel(
    title = title,
    desc = description,
    date = date,
    imageUrl = imageUrl,
)
