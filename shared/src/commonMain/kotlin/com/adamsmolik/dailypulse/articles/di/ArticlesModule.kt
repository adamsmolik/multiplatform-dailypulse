package com.adamsmolik.dailypulse.articles.di

import com.adamsmolik.dailypulse.articles.data.ArticlesDataSource
import com.adamsmolik.dailypulse.articles.data.ArticlesRepository
import com.adamsmolik.dailypulse.articles.data.ArticlesService
import com.adamsmolik.dailypulse.articles.application.ArticlesUseCase
import com.adamsmolik.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val articlesModule = module {
    singleOf(::ArticlesService)
    singleOf(::ArticlesUseCase)
    singleOf(::ArticlesViewModel)
    singleOf(::ArticlesDataSource)
    singleOf(::ArticlesRepository)
}
