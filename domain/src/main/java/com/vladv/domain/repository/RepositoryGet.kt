package com.vladv.domain.repository

import com.vladv.domain.model.ModelProbe
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.model.ModelUnit

interface RepositoryGet {
    suspend fun getRecord(): List<ModelRecord>
    suspend fun getUnit(): List<Int>
    suspend fun getProb(): List<Int>
    suspend fun getFullProb(): List<ModelProbe>
    suspend fun getFullUnit(): List<ModelUnit>

}