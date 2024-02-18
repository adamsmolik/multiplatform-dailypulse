package com.adamsmolik.dailypulse.di

import com.adamsmolik.dailypulse.core.network.di.networkModule
import com.adamsmolik.dailypulse.data.article.di.articleDataModule
import com.adamsmolik.dailypulse.data.source.di.sourceDataModule
import com.adamsmolik.dailypulse.presentation.article.di.articlePresentationModule
import com.adamsmolik.dailypulse.presentation.source.di.sourcePresentationModule

val sharedKoinModules = listOf(
    articleDataModule,
    articlePresentationModule,
    sourceDataModule,
    sourcePresentationModule,
    networkModule,
)
