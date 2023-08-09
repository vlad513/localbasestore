package com.vladv.data.repository

import com.vladv.data.extensions.data.mapProbe
import com.vladv.data.extensions.data.mapRecord
import com.vladv.data.extensions.data.mapUnit
import com.vladv.data.storage.Dao
import com.vladv.domain.model.ModelProbe
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.model.ModelUnit
import com.vladv.domain.repository.RepositorySave


class RepositorySaveImpl(private val dao: Dao) : RepositorySave {
    override suspend fun saveUnit(unit: ModelUnit) {
        dao.addUnit(mapUnit(unit = unit))
    }

    override suspend fun saveProbe(probe: ModelProbe) {
        dao.addProbe(mapProbe(probe = probe))
    }

    override suspend fun saveRecord(record: ModelRecord) {
        dao.addRecord(mapRecord(record = record))
    }

}