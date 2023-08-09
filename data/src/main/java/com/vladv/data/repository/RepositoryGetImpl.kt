package com.vladv.data.repository

import com.vladv.data.extensions.domain.mapFullProbe
import com.vladv.data.extensions.domain.mapFullUnit
import com.vladv.data.extensions.domain.mapProbe
import com.vladv.domain.repository.RepositoryGet
import com.vladv.data.storage.Dao
import com.vladv.data.extensions.domain.mapToDomain
import com.vladv.data.extensions.domain.mapUnit
import com.vladv.domain.model.ModelProbe
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.model.ModelUnit


class RepositoryGetImpl(val dao: Dao) : RepositoryGet {
    override suspend fun getRecord(): List<ModelRecord> {
        return mapToDomain(dao.readAllData())
    }

    override suspend fun getUnit(): List<Int> {
        return mapUnit(dao.readUnit())
    }

    override suspend fun getProb(): List<Int> {
        return mapProbe(dao.readProbe())
    }

    override suspend fun getFullProb(): List<ModelProbe> {
        return mapFullProbe(dao.readProbe())
    }

    override suspend fun getFullUnit(): List<ModelUnit> {
        return mapFullUnit(dao.readUnit())
    }


}