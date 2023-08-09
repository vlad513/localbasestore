package com.vladv.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vladv.data.model.ModelDataProbe
import com.vladv.data.model.ModelDataRecord
import com.vladv.data.model.ModelDataUnit


@Dao
interface Dao {
    @Query("SELECT * FROM record_table")
    suspend fun readAllData(): List<ModelDataRecord>

    @Query("SELECT * FROM record_table where id_probe = :id")
    suspend fun readSortRecord(id:Int): List<ModelDataRecord>

    @Query("SELECT * FROM unit_table")
    suspend fun readUnit(): List<ModelDataUnit>

    @Query("SELECT * FROM probe_table")
    suspend fun readProbe(): List<ModelDataProbe>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUnit(unit: ModelDataUnit)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProbe(probe: ModelDataProbe)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecord(record: ModelDataRecord)



}