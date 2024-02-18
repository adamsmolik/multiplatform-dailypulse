// ktlint-disable filename

package com.adamsmolik.dailypulse.domain.article.model

data class ArticleModel(
    val title: String,
    val desc: String?,
    val date: String,
    val imageUrl: String?,
)
