package com.vladv.data.extensions.data

import com.vladv.data.model.ModelDataUnit
import com.vladv.data.repository.RepositorySaveImpl
import com.vladv.domain.model.ModelUnit

fun RepositorySaveImpl.mapUnit(unit: ModelUnit): ModelDataUnit {
    return ModelDataUnit(id = unit.id, unit = unit.unit)
}