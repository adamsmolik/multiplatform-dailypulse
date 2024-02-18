package com.adamsmolik.dailypulse.core.network

import com.adamsmolik.dailypulse.core.network.di.NewsJson
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json

const val TIMEOUT_DURATION: Long = 60_000

fun newsHttpClient(
    json: NewsJson,
    domain: String,
    apiKey: String,
) = HttpClient {
    install(ContentNegotiation) { json(json = json) }

    install(DefaultRequest) {
        apply {
            url {
                protocol = URLProtocol.HTTPS
                host = domain

                parameters.append("apiKey", apiKey)
            }
        }
    }

    install(HttpTimeout) {
        requestTimeoutMillis = TIMEOUT_DURATION
        connectTimeoutMillis = TIMEOUT_DURATION
        socketTimeoutMillis = TIMEOUT_DURATION
    }

    install(Logging) {
        // TODO
        logger = object : Logger {
            override fun log(message: String) {
                println(message)
            }
        }
        level = LogLevel.ALL
        filter { request -> request.url.host.contains(domain) }
        sanitizeHeader { header -> header == HttpHeaders.Authorization }
    }
}