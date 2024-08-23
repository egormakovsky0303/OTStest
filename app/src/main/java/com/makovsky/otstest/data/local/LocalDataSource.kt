package com.makovsky.otstest.data.local

import androidx.lifecycle.LiveData
import com.makovsky.otstest.data.local.model.BootLocal

interface LocalDataSource {
    suspend fun saveBoot(time: Long)
    suspend fun getBoot(): LiveData<BootLocal?>
    suspend fun getAllBoots(): List<BootLocal>
}