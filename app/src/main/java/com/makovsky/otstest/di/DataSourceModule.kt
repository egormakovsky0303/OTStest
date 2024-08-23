package com.makovsky.otstest.di

import com.makovsky.otstest.data.MainRepositoryImpl
import com.makovsky.otstest.data.local.LocalDataSource
import com.makovsky.otstest.data.local.LocalDataSourceImpl
import com.makovsky.otstest.domain.repository.MainRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataSourceModule = module {

    single<LocalDataSource>(named<LocalDataSourceImpl>()) {
        LocalDataSourceImpl(get())
    }

    single<MainRepository> {
        MainRepositoryImpl(
            get(named<LocalDataSourceImpl>()),
        )
    }
}