package com.adamsmolik.dailypulse.core.network

import com.adamsmolik.dailypulse.core.network.di.NewsJson
import com.adamsmolik.dailypulse.core.network.error.HttpException
import com.adamsmolik.dailypulse.core.network.model.ErrorDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.isSuccess
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

    HttpResponseValidator {
        validateResponse { response ->
            if (!response.status.isSuccess()) {
                val error: ErrorDTO = response.body()

//                val failureReason = when (response.status) {
//                        HttpStatusCode.Unauthorized -> "Unauthorized request"
//                        HttpStatusCode.Forbidden -> "${response.status.value} Missing API key."
//                        HttpStatusCode.NotFound -> "Invalid Request"
//                        HttpStatusCode.UpgradeRequired -> "Upgrade to VIP"
//                        HttpStatusCode.RequestTimeout -> "Network Timeout"
//                        in HttpStatusCode.InternalServerError..HttpStatusCode.GatewayTimeout ->
//                            "${response.status.value} Server Error"
//                        else -> "Network error!"
//                    }

                throw HttpException(
                    error = error,
                    response = response,
                    cachedResponseText = response.bodyAsText(),
                )
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