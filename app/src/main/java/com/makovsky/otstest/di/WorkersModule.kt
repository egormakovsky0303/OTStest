package com.makovsky.otstest.di

import com.makovsky.otstest.utils.workers.NotificationsScheduler
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.workmanager.dsl.worker
import org.koin.dsl.module

val workersModule = module {
    worker { NotificationsScheduler(get(), androidContext(), get()) }
}