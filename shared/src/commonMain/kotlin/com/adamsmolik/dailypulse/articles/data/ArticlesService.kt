package com.adamsmolik.dailypulse.articles.data

import com.adamsmolik.dailypulse.articles.data.ArticleRaw
import com.adamsmolik.dailypulse.articles.data.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "2fb5c49a12204e8ea1b78175e8196edd"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse =
            httpClient
                .get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
                .body()
        return response.articles
    }
}
