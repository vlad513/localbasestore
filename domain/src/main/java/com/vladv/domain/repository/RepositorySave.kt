package com.vladv.domain.repository

import com.vladv.domain.model.ModelProbe
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.model.ModelUnit

interface RepositorySave {
    suspend fun saveUnit(unit:ModelUnit)
    suspend fun saveProbe(probe:ModelProbe)
    suspend fun saveRecord(record:ModelRecord)
}