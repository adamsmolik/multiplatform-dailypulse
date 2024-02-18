package com.adamsmolik.dailypulse.data.source.repository

import com.adamsmolik.dailypulse.data.source.api.SourceApi
import com.adamsmolik.dailypulse.data.source.datasource.SourceDataSource
import com.adamsmolik.dailypulse.data.source.model.toModel
import com.adamsmolik.dailypulse.domain.source.model.SourceModel
import com.adamsmolik.dailypulse.domain.source.repository.SourceRepository

class SourceRepositoryImpl(
    private val dataSource: SourceDataSource,
    private val sourceApi: SourceApi,
) : SourceRepository {
    override suspend fun listSources(): List<SourceModel> {
        val sourcesDb = dataSource.getAllSources()
        if (sourcesDb.isEmpty()) {
            dataSource.clearSources()
            val fetchedSources = sourceApi.fetchSources().map { it.toModel() }
            dataSource.insertSources(fetchedSources)
            return fetchedSources
        }
        return sourcesDb
    }
}
