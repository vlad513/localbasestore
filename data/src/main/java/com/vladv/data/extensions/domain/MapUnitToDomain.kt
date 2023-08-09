package com.vladv.data.extensions.domain

import com.vladv.data.model.ModelDataUnit
import com.vladv.data.repository.RepositoryGetImpl


fun RepositoryGetImpl.mapUnit(unit: List<ModelDataUnit>): List<Int> {
    val list = arrayListOf<Int>()
    unit.forEach {
        list.add(it.id)
    }
    return list
}