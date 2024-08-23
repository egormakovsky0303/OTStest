package com.makovsky.otstest.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.makovsky.otstest.data.local.LocalDataSource
import com.makovsky.otstest.data.local.model.BootLocal
import com.makovsky.otstest.domain.entities.Boot
import com.makovsky.otstest.domain.repository.MainRepository

class MainRepositoryImpl(
    private val local: LocalDataSource,
): MainRepository {
    override suspend fun saveBoot(time: Long) {
        local.saveBoot(time)
    }

    override suspend fun getBoot(): LiveData<Boot?> {
        return local.getBoot().map { it?.let { it1 -> Boot(it1.time) } }
    }

    override suspend fun getAllBoots(): List<BootLocal> {
        return local.getAllBoots()
    }
}