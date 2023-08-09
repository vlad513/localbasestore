package com.vladv.domain.usecase

import com.vladv.domain.model.ModelUnit
import com.vladv.domain.repository.RepositorySave

class SaveUnitUseCase(private val repositorySave: RepositorySave) {
    suspend fun execute(unit: ModelUnit) {
        repositorySave.saveUnit(unit = unit)
    }
}