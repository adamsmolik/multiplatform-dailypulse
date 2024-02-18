package com.adamsmolik.dailypulse.data.article.api

import com.adamsmolik.dailypulse.core.network.di.NewsHttpClient
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod
import io.ktor.http.path
import com.adamsmolik.dailypulse.core.base.arch.Result
import com.adamsmolik.dailypulse.core.network.extension.safeRequest
import com.adamsmolik.dailypulse.data.article.model.ArticlesDTO

class ArticleApi(
    private val httpClient: NewsHttpClient,
) {
    private val country = "us"
    private val category = "business"

    suspend fun fetchArticles(): Result<ArticlesDTO> = httpClient.safeRequest {
        url {
            method = HttpMethod.Get
            path("v2/top-headlines")
            parameter("country", country)
            parameter("category", category)
        }
    }
}
