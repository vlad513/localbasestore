package com.vladv.data.extensions.domain

import com.vladv.data.model.ModelDataUnit
import com.vladv.data.repository.RepositoryGetImpl
import com.vladv.domain.model.ModelUnit

fun RepositoryGetImpl.mapFullUnit(unit: List<ModelDataUnit>): List<ModelUnit> {
    val list = arrayListOf<ModelUnit>()
    unit.forEach {
        list.add(ModelUnit(id = it.id,unit = it.unit))
    }
    return list
}