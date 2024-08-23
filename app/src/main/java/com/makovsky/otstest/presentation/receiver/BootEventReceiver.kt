package com.makovsky.otstest.presentation.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.makovsky.otstest.domain.usecase.BaseUseCase
import com.makovsky.otstest.domain.usecase.SaveBootUseCase
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.getKoin

class BootEventReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        runBlocking {
            val saveBootUseCase = getKoin().get<SaveBootUseCase>()
            saveBootUseCase.invoke(this, BaseUseCase.None())
        }
    }
}