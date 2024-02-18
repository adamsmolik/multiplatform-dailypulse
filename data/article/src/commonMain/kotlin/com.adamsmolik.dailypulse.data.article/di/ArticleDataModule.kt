package com.adamsmolik.dailypulse.data.article.di

import com.adamsmolik.dailypulse.data.article.api.ArticleApi
import com.adamsmolik.dailypulse.data.article.datasource.ArticleDataSource
import com.adamsmolik.dailypulse.data.article.repository.ArticleRepositoryImpl
import com.adamsmolik.dailypulse.domain.article.repository.ArticleRepository
import com.adamsmolik.dailypulse.domain.article.usecase.ListArticlesUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val articleDataModule = module {
    singleOf(::ArticleApi)
    singleOf(::ArticleDataSource)
    singleOf(::ListArticlesUseCase)

    single<ArticleRepository> { ArticleRepositoryImpl(get(), get()) }
}
