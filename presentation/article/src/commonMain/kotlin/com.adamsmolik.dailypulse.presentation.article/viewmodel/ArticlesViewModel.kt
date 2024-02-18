package com.adamsmolik.dailypulse.presentation.article.viewmodel

import com.adamsmolik.dailypulse.core.ui.arch.BaseViewModel
import com.adamsmolik.dailypulse.domain.article.usecase.ListArticlesUseCaseInput
import com.adamsmolik.dailypulse.domain.article.usecase.ListArticlesUseCase
import com.adamsmolik.dailypulse.presentation.article.model.ArticlesUiModel
import com.adamsmolik.dailypulse.presentation.article.model.toUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ListArticlesUseCase,
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesUiModel> = MutableStateFlow(
        ArticlesUiModel(loading = true)
    )
    val articlesState: StateFlow<ArticlesUiModel> = _articlesState.asStateFlow()

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(
                ArticlesUiModel(
                    loading = true,
                    articles = _articlesState.value.articles
                )
            )

            val input = ListArticlesUseCaseInput(
                forceRefresh = forceFetch,
            )

            useCase.execute(input)
                .onData {
                    _articlesState.emit(ArticlesUiModel(articles = it.map { item -> item.toUiModel() }))
                }
                .onError {
                    _articlesState.emit(ArticlesUiModel(error = it.toString()))
                }
        }
    }
}
