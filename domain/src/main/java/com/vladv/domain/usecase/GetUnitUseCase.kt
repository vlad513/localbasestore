package com.vladv.domain.usecase

import com.vladv.domain.model.ModelRecord
import com.vladv.domain.model.ModelUnit
import com.vladv.domain.repository.RepositoryGet

class GetUnitUseCase(private val repository: RepositoryGet) {
    suspend fun execute(): List<Int> {
        return repository.getUnit()
    }
}