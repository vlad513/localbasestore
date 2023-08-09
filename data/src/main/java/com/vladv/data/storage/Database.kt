package com.vladv.data.storage


import androidx.room.Database
import androidx.room.RoomDatabase
import com.vladv.data.model.ModelDataProbe
import com.vladv.data.model.ModelDataRecord
import com.vladv.data.model.ModelDataUnit

@Database(entities = [ModelDataRecord::class, ModelDataProbe::class, ModelDataUnit::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun getRunDao(): Dao
}