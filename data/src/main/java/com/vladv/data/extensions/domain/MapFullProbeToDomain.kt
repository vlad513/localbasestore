package com.vladv.data.extensions.domain

import com.vladv.data.model.ModelDataProbe
import com.vladv.data.repository.RepositoryGetImpl
import com.vladv.domain.model.ModelProbe

fun RepositoryGetImpl.mapFullProbe(probe: List<ModelDataProbe>): List<ModelProbe> {
    val list = arrayListOf<ModelProbe>()
    probe.forEach {
        list.add(ModelProbe(id = it.id, name = it.name, alias = it.alias))
    }
    return list
}