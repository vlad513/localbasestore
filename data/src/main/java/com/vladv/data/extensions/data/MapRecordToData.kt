package com.vladv.data.extensions.data

import com.vladv.data.model.ModelDataRecord
import com.vladv.data.repository.RepositorySaveImpl
import com.vladv.domain.model.ModelRecord

fun RepositorySaveImpl.mapRecord(record: ModelRecord): ModelDataRecord {
    return ModelDataRecord(
        id = record.id,
        timestamp = record.timestamp,
        numberRecord = record.numberRecord,
        value = record.value,
        idUnit = record.idUnit,
        idProbe = record.idProbe
    )
}