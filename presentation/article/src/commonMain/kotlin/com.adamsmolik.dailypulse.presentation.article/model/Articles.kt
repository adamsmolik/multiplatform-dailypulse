package com.adamsmolik.dailypulse.presentation.article.model

import com.adamsmolik.dailypulse.domain.article.model.ArticleModel

data class ArticleUiModel(
    val title: String,
    val desc: String,
    val date: String,
    val imageUrl: String,
)

// TODO @Immutable :-(
data class ArticlesUiModel(
    val articles: List<ArticleUiModel> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null,
)

fun ArticleModel.toUiModel() = ArticleUiModel(
    title = title,
    desc = desc ?: "Click to find out more",
    date = date,
    imageUrl = imageUrl
        ?: "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080",
)
