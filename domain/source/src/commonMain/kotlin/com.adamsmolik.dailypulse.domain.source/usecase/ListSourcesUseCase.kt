package com.adamsmolik.dailypulse.domain.source.usecase

import com.adamsmolik.dailypulse.core.base.arch.Result
import com.adamsmolik.dailypulse.core.base.arch.UseCaseInputLess
import com.adamsmolik.dailypulse.domain.source.model.SourceModel
import com.adamsmolik.dailypulse.domain.source.repository.SourceRepository

class ListSourcesUseCase(
    private val sourceRepository: SourceRepository,
) : UseCaseInputLess<List<SourceModel>> {
    override suspend fun execute(): Result<List<SourceModel>> = sourceRepository.listSources()
}
