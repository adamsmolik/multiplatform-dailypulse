package com.adamsmolik.dailypulse.articles.presentation

import com.adamsmolik.dailypulse.articles.application.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)
