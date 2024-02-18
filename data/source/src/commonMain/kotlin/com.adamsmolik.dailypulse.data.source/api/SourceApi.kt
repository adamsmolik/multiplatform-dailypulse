package com.adamsmolik.dailypulse.data.source.api

import com.adamsmolik.dailypulse.data.source.model.SourceDTO
import com.adamsmolik.dailypulse.data.source.model.SourcesDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourceApi(
    private val httpClient: HttpClient,
) {
    private val apiKey = "2fb5c49a12204e8ea1b78175e8196edd"

    suspend fun fetchSources(): List<SourceDTO> {
        val response: SourcesDTO =
            httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()
        return response.sources
    }
}
