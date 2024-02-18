package com.adamsmolik.dailypulse.data.source.api

import com.adamsmolik.dailypulse.core.network.di.NewsHttpClient
import io.ktor.http.HttpMethod
import io.ktor.http.path
import com.adamsmolik.dailypulse.core.base.arch.Result
import com.adamsmolik.dailypulse.core.network.extension.safeRequest
import com.adamsmolik.dailypulse.data.source.model.SourcesDTO

class SourceApi(
    private val httpClient: NewsHttpClient,
) {
    suspend fun fetchSources(): Result<SourcesDTO> = httpClient.safeRequest {
        url {
            method = HttpMethod.Get
            path("v2/top-headlines/sources")
        }
    }
}
