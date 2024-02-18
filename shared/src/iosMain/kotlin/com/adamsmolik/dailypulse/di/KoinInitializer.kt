package com.adamsmolik.dailypulse.di

import com.adamsmolik.dailypulse.core.db.di.databaseModule
import com.adamsmolik.dailypulse.presentation.article.viewmodel.ArticlesViewModel
import com.adamsmolik.dailypulse.presentation.source.viewmodel.SourcesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedKoinModules + databaseModule

    startKoin {
        modules(modules)
    }
}

// TODO try to move into presentation article ios
class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}

class SourcesInjector : KoinComponent {
    val sourcesViewModel: SourcesViewModel by inject()
}
