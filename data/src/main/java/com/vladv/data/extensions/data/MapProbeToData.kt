package com.vladv.data.extensions.data

import com.vladv.data.model.ModelDataProbe
import com.vladv.data.repository.RepositorySaveImpl
import com.vladv.domain.model.ModelProbe

fun RepositorySaveImpl.mapProbe(probe: ModelProbe): ModelDataProbe {
     return ModelDataProbe(id = probe.id, name = probe.name, alias = probe.alias)
}