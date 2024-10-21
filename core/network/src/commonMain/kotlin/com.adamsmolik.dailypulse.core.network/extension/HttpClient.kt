package com.adamsmolik.dailypulse.core.network.extension

import com.adamsmolik.dailypulse.core.base.arch.Result
import com.adamsmolik.dailypulse.core.base.arch.resultData
import com.adamsmolik.dailypulse.core.base.arch.resultError
import com.adamsmolik.dailypulse.core.base.error.AppError
import com.adamsmolik.dailypulse.core.network.error.HttpException
import com.adamsmolik.dailypulse.core.network.model.toModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import kotlinx.serialization.SerializationException

suspend inline fun <reified T> HttpClient.safeRequest(
    block: HttpRequestBuilder.() -> Unit,
): Result<T> = try {
    val response = request { block() }
    resultData(response.body())
} catch (exception: ClientRequestException) {
    resultError(AppError.NetworkError.InvalidResponse(exception, null))
} catch (exception: HttpException) {
    resultError(
        AppError.NetworkError.ResponseError(
            cause = exception,
            responseError = exception.error.toModel()
        )
    )
} catch (exception: SerializationException) {
    // TODO log error
    resultError(AppError.NetworkError.InvalidResponse(exception, null))
} catch (exception: Exception) {
    resultError(AppError.NetworkError.InvalidResponse(exception, null))
}
