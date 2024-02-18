package com.adamsmolik.dailypulse.core.network.di

import com.adamsmolik.dailypulse.core.network.newsHttpClient
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import org.koin.dsl.module

typealias NewsJson = Json

typealias NewsHttpClient = HttpClient

val networkModule = module {
    single<NewsJson> {
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        }
    }

    single<NewsHttpClient> {
        newsHttpClient(
            json = get(),
            domain = "newsapi.org",
            apiKey = "2fb5c49a12204e8ea1b78175e8196edd"
        )
    }
}
