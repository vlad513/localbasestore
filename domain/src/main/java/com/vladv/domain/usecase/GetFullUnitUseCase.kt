package com.vladv.domain.usecase

import com.vladv.domain.model.ModelUnit
import com.vladv.domain.repository.RepositoryGet

class GetFullUnitUseCase (private val repository: RepositoryGet) {
    suspend fun execute(): List<ModelUnit> {
        return repository.getFullUnit()
    }
}