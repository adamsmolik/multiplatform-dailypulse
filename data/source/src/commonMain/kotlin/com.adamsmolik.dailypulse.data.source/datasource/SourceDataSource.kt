package com.adamsmolik.dailypulse.data.source.datasource

import com.adamsmolik.dailypulse.core.db.DailyPulseDatabase
import com.adamsmolik.dailypulse.domain.source.model.SourceModel

class SourceDataSource(
    private val database: DailyPulseDatabase,
) {

    fun getAllSources(): List<SourceModel> = database.dailyPulseDatabaseQueries
        .selectAllSources(::mapToSource)
        .executeAsList()

    fun insertSources(sources: List<SourceModel>) {
        database.dailyPulseDatabaseQueries.transaction {
            sources.forEach { source ->
                insertSource(source)
            }
        }
    }

    fun clearSources() = database.dailyPulseDatabaseQueries.removeAllSources()

    private fun insertSource(source: SourceModel) {
        database.dailyPulseDatabaseQueries.insertSource(
            source.id,
            source.name,
            source.desc,
            source.language,
            source.country,
        )
    }

    private fun mapToSource(
        id: String,
        name: String,
        desc: String,
        language: String,
        country: String
    ): SourceModel = SourceModel(
        id,
        name,
        desc,
        language,
        country,
    )
}
