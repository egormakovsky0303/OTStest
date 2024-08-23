package com.makovsky.otstest.utils.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.makovsky.otstest.R
import com.makovsky.otstest.domain.entities.Boot
import com.makovsky.otstest.domain.usecase.BaseUseCase
import com.makovsky.otstest.domain.usecase.GetAllBootsUseCase
import com.makovsky.otstest.utils.helpers.NotificationHelper
import kotlinx.coroutines.runBlocking
import org.koin.core.component.KoinComponent
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NotificationsScheduler(
    private val getAllBootsUseCase: GetAllBootsUseCase,
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters), KoinComponent {

    companion object {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH)
    }

    override fun doWork(): Result {
        runBlocking {
            getAllBootsUseCase.invoke(this, BaseUseCase.None()){
                it.either(
                    {},
                    { allBoots ->
                        val title = applicationContext.getString(R.string.special_body)
                        NotificationHelper(applicationContext).showNotification(title, buildText(allBoots))
                    }
                )
            }
        }
        return Result.success()
    }

    private fun buildText(allItems: List<Boot>): String {
        return when (allItems.size) {
            0 -> applicationContext.getString(R.string.no_boots)
            1 -> applicationContext.getString(R.string.boots_detected, dateFormat.format(Date(allItems.first().time)))
            else -> applicationContext.getString(R.string.last_boots_delta, allItems.last().time - allItems[allItems.size - 2].time)
        }
    }
}