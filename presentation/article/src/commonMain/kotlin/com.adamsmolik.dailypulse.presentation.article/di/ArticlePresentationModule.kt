package com.adamsmolik.dailypulse.presentation.article.di

import com.adamsmolik.dailypulse.presentation.article.viewmodel.ArticlesViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val articlePresentationModule = module {
    singleOf(::ArticlesViewModel)
}
