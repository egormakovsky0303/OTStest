package com.makovsky.otstest.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.makovsky.otstest.data.local.model.BootLocal

@Dao
abstract class BootDao {

    @Query("SELECT * FROM boot_table")
    abstract suspend fun getAll(): List<BootLocal>

    @Insert
    abstract suspend fun save(item: BootLocal)

    @Query("SELECT * FROM boot_table ORDER BY time DESC LIMIT 1")
    abstract fun loadLast(): LiveData<BootLocal?>

}