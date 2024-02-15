package com.adamsmolik.dailypulse.sources.di

import com.adamsmolik.dailypulse.sources.application.SourcesUseCase
import com.adamsmolik.dailypulse.sources.data.SourcesDataSource
import com.adamsmolik.dailypulse.sources.data.SourcesRepository
import com.adamsmolik.dailypulse.sources.data.SourcesService
import com.adamsmolik.dailypulse.sources.presentation.SourcesViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sourcesModule = module {
    singleOf(::SourcesService)
    singleOf(::SourcesUseCase)
    singleOf(::SourcesDataSource)
    singleOf(::SourcesRepository)
    singleOf(::SourcesViewModel)
}
