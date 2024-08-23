package com.makovsky.otstest.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.makovsky.otstest.data.db.dao.BootDao
import com.makovsky.otstest.data.local.model.BootLocal

@Database(
    entities = [
        BootLocal::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class OtsDatabase : RoomDatabase() {
    abstract fun getBootDao(): BootDao
}