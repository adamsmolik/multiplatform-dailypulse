package com.adamsmolik.dailypulse.sources.application

import com.adamsmolik.dailypulse.sources.data.SourceRaw
import com.adamsmolik.dailypulse.sources.data.SourcesRepository

class SourcesUseCase(
    private val repo: SourcesRepository,
) {

    suspend fun getSources(): List<Source> {
        val sourcesRaw = repo.getAllSources()

        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>): List<Source> = sourcesRaw.map { raw ->
        Source(
            raw.id,
            raw.name,
            raw.desc,
            mapOrigin(raw),
        )
    }

    private fun mapOrigin(raw: SourceRaw) = "${raw.country} - ${raw.language}"
}
