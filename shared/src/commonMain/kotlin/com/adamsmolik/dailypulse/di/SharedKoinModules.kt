package com.adamsmolik.dailypulse.di

import com.adamsmolik.dailypulse.articles.di.articlesModule
import com.adamsmolik.dailypulse.sources.di.sourcesModule

val sharedKoinModules = listOf(
    articlesModule,
    sourcesModule,
    networkModule,
)