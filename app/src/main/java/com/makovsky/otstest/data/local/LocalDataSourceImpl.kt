package com.makovsky.otstest.data.local

import androidx.lifecycle.LiveData
import com.makovsky.otstest.data.db.OtsDatabase
import com.makovsky.otstest.data.local.model.BootLocal

class LocalDataSourceImpl(
    private val database: OtsDatabase,
): LocalDataSource {
    override suspend fun saveBoot(time: Long) {
        database.getBootDao().save(BootLocal(time = time))
    }

    override suspend fun getBoot(): LiveData<BootLocal?> {
        return database.getBootDao().loadLast()
    }

    override suspend fun getAllBoots(): List<BootLocal> {
        return database.getBootDao().getAll()
    }
}