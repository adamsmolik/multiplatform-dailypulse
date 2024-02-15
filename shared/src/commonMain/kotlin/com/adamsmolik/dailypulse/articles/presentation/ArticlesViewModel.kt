package com.adamsmolik.dailypulse.articles.presentation

import com.adamsmolik.dailypulse.BaseViewModel
import com.adamsmolik.dailypulse.articles.application.ArticlesUseCase
import com.adamsmolik.dailypulse.articles.presentation.ArticlesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase,
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(
        ArticlesState(loading = true)
    )
    val articlesState: StateFlow<ArticlesState> = _articlesState.asStateFlow()

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(
                ArticlesState(
                    loading = true,
                    articles = _articlesState.value.articles
                )
            )

            val fetchedArticles = useCase.getArticles(forceFetch)

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}
