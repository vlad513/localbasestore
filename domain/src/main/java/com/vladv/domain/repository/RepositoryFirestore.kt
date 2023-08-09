package com.vladv.domain.repository

import com.vladv.domain.model.ModelProbe
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.model.ModelUnit

interface RepositoryFirestore {
    suspend fun addRecord(record:List<ModelRecord>)
    suspend fun addProbe(probe:List<ModelProbe>)
    suspend fun addUnit(unit:List<ModelUnit>)
}