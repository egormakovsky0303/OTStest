package com.makovsky.otstest.di

import androidx.room.Room
import com.makovsky.otstest.data.db.OtsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val DATABASE_NAME = "ots-database.db"

val applicationModule = module {
    single {
        Room
            .databaseBuilder(androidContext(), OtsDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<OtsDatabase>().getBootDao() }
}