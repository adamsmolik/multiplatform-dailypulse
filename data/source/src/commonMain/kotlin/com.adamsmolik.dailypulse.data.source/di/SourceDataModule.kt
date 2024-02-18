package com.adamsmolik.dailypulse.data.source.di

import com.adamsmolik.dailypulse.data.source.api.SourceApi
import com.adamsmolik.dailypulse.data.source.datasource.SourceDataSource
import com.adamsmolik.dailypulse.data.source.repository.SourceRepositoryImpl
import com.adamsmolik.dailypulse.domain.source.repository.SourceRepository
import com.adamsmolik.dailypulse.domain.source.usecase.ListSourcesUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sourceDataModule = module {
    singleOf(::SourceApi)
    singleOf(::SourceDataSource)
    singleOf(::ListSourcesUseCase)

    single<SourceRepository> { SourceRepositoryImpl(get(), get()) }
}
