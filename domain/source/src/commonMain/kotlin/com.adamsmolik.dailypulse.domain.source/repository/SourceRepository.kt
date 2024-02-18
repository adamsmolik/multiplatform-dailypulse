package com.adamsmolik.dailypulse.domain.source.repository

import com.adamsmolik.dailypulse.domain.source.model.SourceModel
import com.adamsmolik.dailypulse.core.base.arch.Result

interface SourceRepository {
    suspend fun listSources(): Result<List<SourceModel>>
}
