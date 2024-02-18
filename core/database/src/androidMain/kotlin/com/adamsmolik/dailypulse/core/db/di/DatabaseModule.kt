package com.adamsmolik.dailypulse.core.db.di

import app.cash.sqldelight.db.SqlDriver
import com.adamsmolik.dailypulse.core.db.DailyPulseDatabase
import com.adamsmolik.dailypulse.core.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}
