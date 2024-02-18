package com.adamsmolik.dailypulse.presentation.source.di

import com.adamsmolik.dailypulse.presentation.source.viewmodel.SourcesViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val sourcePresentationModule = module {
    singleOf(::SourcesViewModel)
}
