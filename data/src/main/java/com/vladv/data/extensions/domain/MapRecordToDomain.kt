package com.vladv.data.extensions.domain

import com.vladv.data.model.ModelDataRecord
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.repository.RepositoryGet

fun RepositoryGet.mapToDomain(record: List<ModelDataRecord>): List<ModelRecord> {
    val list = arrayListOf<ModelRecord>()
    record.forEach {
        list.add(
            ModelRecord(
                id = it.id,
                timestamp = it.timestamp,
                numberRecord = it.numberRecord,
                value = it.value,
                idProbe = it.idProbe,
                idUnit = it.idUnit
            )
        )
    }
    return list
}