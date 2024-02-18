package com.adamsmolik.dailypulse.domain.source.repository

import com.adamsmolik.dailypulse.domain.source.model.SourceModel

interface SourceRepository {
    suspend fun listSources(): List<SourceModel>
}
