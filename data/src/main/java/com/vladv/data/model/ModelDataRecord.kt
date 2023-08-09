package com.vladv.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "record_table", foreignKeys = [ForeignKey(
        entity = ModelDataProbe::class,
        parentColumns = ["id"],
        childColumns = ["id_probe"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    ), ForeignKey(
        entity = ModelDataUnit::class,
        parentColumns = ["id"],
        childColumns = ["id_unit"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class ModelDataRecord(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val timestamp: Int,
    @ColumnInfo(name = "number_record") val numberRecord: Int,
    val value: Int,
    @ColumnInfo(name = "id_unit") val idUnit: Int,
    @ColumnInfo(name = "id_probe") val idProbe: Int
)