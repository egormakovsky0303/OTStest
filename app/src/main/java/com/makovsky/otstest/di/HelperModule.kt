package com.makovsky.otstest.di

import com.makovsky.otstest.utils.helpers.NotificationHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val helperModule = module {
    single { NotificationHelper(androidContext()) }
}