package com.adamsmolik.dailypulse.android.di

import com.adamsmolik.dailypulse.articles.presentation.ArticlesViewModel
import com.adamsmolik.dailypulse.sources.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { ArticlesViewModel(useCase = get()) }
    viewModel { SourcesViewModel(useCase = get()) }
}
