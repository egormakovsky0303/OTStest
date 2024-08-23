package com.makovsky.otstest.di

import com.makovsky.otstest.domain.usecase.GetAllBootsUseCase
import com.makovsky.otstest.domain.usecase.GetLastBootUseCase
import com.makovsky.otstest.domain.usecase.SaveBootUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetLastBootUseCase(get()) }
    single { SaveBootUseCase(get()) }
    single { GetAllBootsUseCase(get()) }
}