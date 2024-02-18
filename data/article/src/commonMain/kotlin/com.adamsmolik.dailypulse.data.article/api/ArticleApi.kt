package com.adamsmolik.dailypulse.data.article.api

import com.adamsmolik.dailypulse.data.article.model.ArticleDTO
import com.adamsmolik.dailypulse.data.article.model.ArticlesDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleApi(
    private val httpClient: HttpClient,
) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "2fb5c49a12204e8ea1b78175e8196edd"

    suspend fun fetchArticles(): List<ArticleDTO> {
        val response: ArticlesDTO =
            httpClient
                .get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()
        return response.articles
    }
}
