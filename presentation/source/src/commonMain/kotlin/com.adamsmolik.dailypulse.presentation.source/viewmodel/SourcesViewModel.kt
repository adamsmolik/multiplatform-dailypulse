package com.adamsmolik.dailypulse.presentation.source.viewmodel

import com.adamsmolik.dailypulse.core.ui.arch.BaseViewModel
import com.adamsmolik.dailypulse.domain.source.usecase.ListSourcesUseCase
import com.adamsmolik.dailypulse.presentation.source.model.SourcesUiModel
import com.adamsmolik.dailypulse.presentation.source.model.toUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(
    private val useCase: ListSourcesUseCase,
) : BaseViewModel() {

    private val _sourcesState = MutableStateFlow(
        SourcesUiModel(loading = true)
    )
    val sourcesState: StateFlow<SourcesUiModel> get() = _sourcesState.asStateFlow()

    init {
        getSources()
    }

    private fun getSources() {
        scope.launch {
            _sourcesState.emit(
                SourcesUiModel(
                    loading = true,
                    sources = _sourcesState.value.sources,
                )
            )

            val sources = useCase.execute()

            _sourcesState.emit(
                SourcesUiModel(sources = sources.map { it.toUiModel() })
            )
        }
    }
}
