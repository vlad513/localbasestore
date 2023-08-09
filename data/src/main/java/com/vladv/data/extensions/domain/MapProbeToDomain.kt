package com.vladv.data.extensions.domain

import com.vladv.data.model.ModelDataProbe
import com.vladv.data.repository.RepositoryGetImpl

fun RepositoryGetImpl.mapProbe(probe: List<ModelDataProbe>): List<Int> {
    val list = arrayListOf<Int>()
    probe.forEach {
        list.add(it.id)
    }
    return list
}