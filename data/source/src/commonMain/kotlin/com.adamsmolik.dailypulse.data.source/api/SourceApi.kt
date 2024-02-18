package com.adamsmolik.dailypulse.data.source.api

import com.adamsmolik.dailypulse.core.network.di.NewsHttpClient
import com.adamsmolik.dailypulse.data.source.model.SourceDTO
import com.adamsmolik.dailypulse.data.source.model.SourcesDTO
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.path

class SourceApi(
    private val httpClient: NewsHttpClient,
) {
    suspend fun fetchSources(): List<SourceDTO> {
        val response: SourcesDTO = httpClient.request {
            url {
                method = HttpMethod.Get
                path("v2/top-headlines/sources")
            }
        }.body()

        return response.sources
    }
}
