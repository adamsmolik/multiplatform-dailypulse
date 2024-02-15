package com.adamsmolik.dailypulse.sources.di

import com.adamsmolik.dailypulse.sources.application.SourcesUseCase
import com.adamsmolik.dailypulse.sources.data.SourcesDataSource
import com.adamsmolik.dailypulse.sources.data.SourcesRepository
import com.adamsmolik.dailypulse.sources.data.SourcesService
import com.adamsmolik.dailypulse.sources.presentation.SourcesViewModel
import org.koin.dsl.module

val sourcesModule = module {
    single<SourcesService> { SourcesService(get()) }
    single<SourcesUseCase> { SourcesUseCase(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
}
