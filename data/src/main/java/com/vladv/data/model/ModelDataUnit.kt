package com.vladv.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "unit_table")
data class ModelDataUnit (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("unit")
    val unit:String
)