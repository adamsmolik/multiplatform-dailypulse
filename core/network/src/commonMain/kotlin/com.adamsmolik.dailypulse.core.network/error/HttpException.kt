package com.adamsmolik.dailypulse.core.network.error

import com.adamsmolik.dailypulse.core.network.model.ErrorDTO
import io.ktor.client.plugins.ResponseException
import io.ktor.client.statement.HttpResponse

class HttpException(
    val error: ErrorDTO,
    response: HttpResponse,
    cachedResponseText: String,
) : ResponseException(response, cachedResponseText)
