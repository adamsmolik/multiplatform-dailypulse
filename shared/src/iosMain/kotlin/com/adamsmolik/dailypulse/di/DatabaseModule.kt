package com.adamsmolik.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.adamsmolik.dailypulse.core.db.DailyPulseDatabase
import com.adamsmolik.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

// TODO move into db module
val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}
