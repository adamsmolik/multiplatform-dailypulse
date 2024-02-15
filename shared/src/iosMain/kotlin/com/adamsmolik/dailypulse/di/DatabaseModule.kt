package com.adamsmolik.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.adamsmolik.dailypulse.db.DailyPulseDatabase
import com.adamsmolik.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}
