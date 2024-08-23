package com.makovsky.otstest.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_table")
data class BootLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val time: Long,
)
