package com.adamsmolik.dailypulse.core.network.model

import com.adamsmolik.dailypulse.core.base.error.ResponseErrorModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorDTO(
    @SerialName("status")
    val status: String,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
)

fun ErrorDTO.toModel() = ResponseErrorModel(
    status = status,
    code = code,
    message = message,
)
