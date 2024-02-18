package com.adamsmolik.dailypulse.data.article.api

import com.adamsmolik.dailypulse.core.network.di.NewsHttpClient
import com.adamsmolik.dailypulse.data.article.model.ArticleDTO
import com.adamsmolik.dailypulse.data.article.model.ArticlesDTO
import io.ktor.client.call.body
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.path

class ArticleApi(
    private val httpClient: NewsHttpClient,
) {
    private val country = "us"
    private val category = "business"

    suspend fun fetchArticles(): List<ArticleDTO> {
        val response: ArticlesDTO = httpClient.request {
            url {
                method = HttpMethod.Get
                path("v2/top-headlines")
                parameter("country", country)
                parameter("category", category)
            }
        }.body()

        return response.articles
    }
}
