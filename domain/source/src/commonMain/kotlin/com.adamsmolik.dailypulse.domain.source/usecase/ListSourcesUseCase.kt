package com.adamsmolik.dailypulse.domain.source.usecase

import com.adamsmolik.dailypulse.core.base.arch.UseCaseInputLess
import com.adamsmolik.dailypulse.domain.source.model.SourceModel
import com.adamsmolik.dailypulse.domain.source.repository.SourceRepository
import com.adamsmolik.dailypulse.core.base.arch.Result

class ListSourcesUseCase(
    private val sourceRepository: SourceRepository,
) : UseCaseInputLess<List<SourceModel>> {
    override suspend fun execute(): Result<List<SourceModel>> = sourceRepository.listSources()
}
