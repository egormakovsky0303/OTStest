package com.makovsky.otstest.domain.repository

import androidx.lifecycle.LiveData
import com.makovsky.otstest.data.local.model.BootLocal
import com.makovsky.otstest.domain.entities.Boot

interface MainRepository {
    suspend fun saveBoot(time: Long)
    suspend fun getBoot(): LiveData<Boot?>
    suspend fun getAllBoots(): List<BootLocal>
}