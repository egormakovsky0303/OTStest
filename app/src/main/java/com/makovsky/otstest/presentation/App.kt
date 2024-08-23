package com.makovsky.otstest.presentation

import android.app.Application
import androidx.work.Configuration
import com.makovsky.otstest.di.applicationModule
import com.makovsky.otstest.di.dataSourceModule
import com.makovsky.otstest.di.helperModule
import com.makovsky.otstest.di.useCaseModule
import com.makovsky.otstest.di.viewModelModule
import com.makovsky.otstest.di.workersModule
import com.makovsky.otstest.utils.helpers.NotificationHelper
import com.makovsky.otstest.utils.workers.NotificationsScheduler
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class App: Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
        getKoin().get<NotificationHelper>().createChannel()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            workManagerFactory()
            modules(
                listOf(
                    applicationModule,
                    dataSourceModule,
                    viewModelModule,
                    useCaseModule,
                    workersModule,
                    helperModule
                )
            )
        }

    }
}