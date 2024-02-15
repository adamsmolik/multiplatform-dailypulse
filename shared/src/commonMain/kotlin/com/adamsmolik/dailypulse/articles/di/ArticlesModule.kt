package com.adamsmolik.dailypulse.articles.di

import com.adamsmolik.dailypulse.articles.data.ArticlesDataSource
import com.adamsmolik.dailypulse.articles.data.ArticlesRepository
import com.adamsmolik.dailypulse.articles.data.ArticlesService
import com.adamsmolik.dailypulse.articles.application.ArticlesUseCase
import com.adamsmolik.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}
