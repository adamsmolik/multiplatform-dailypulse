package com.adamsmolik.dailypulse.data.source.repository

import com.adamsmolik.dailypulse.data.source.api.SourceApi
import com.adamsmolik.dailypulse.data.source.datasource.SourceDataSource
import com.adamsmolik.dailypulse.data.source.model.toModel
import com.adamsmolik.dailypulse.domain.source.model.SourceModel
import com.adamsmolik.dailypulse.domain.source.repository.SourceRepository
import com.adamsmolik.dailypulse.core.base.arch.Result
import com.adamsmolik.dailypulse.core.base.arch.map
import com.adamsmolik.dailypulse.core.base.arch.resultData

class SourceRepositoryImpl(
    private val dataSource: SourceDataSource,
    private val sourceApi: SourceApi,
) : SourceRepository {
    override suspend fun listSources(): Result<List<SourceModel>> {
        val sourcesDb = dataSource.getAllSources()

        return if(sourcesDb.isEmpty()) {
            dataSource.clearSources()
            val fetchedSources = sourceApi.fetchSources().map {
                val sources = it.sources.map { item -> item.toModel() }
                dataSource.insertSources(sources)
                sources
            }
            fetchedSources
        } else {
            resultData(sourcesDb)
        }
    }
}
