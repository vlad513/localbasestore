package com.vladv.domain.usecase

import com.vladv.domain.model.ModelProbe
import com.vladv.domain.repository.RepositorySave

class SaveProbeUseCase (private val repositorySave: RepositorySave) {
    suspend fun execute(probe: ModelProbe) {
        repositorySave.saveProbe(probe = probe)
    }
}