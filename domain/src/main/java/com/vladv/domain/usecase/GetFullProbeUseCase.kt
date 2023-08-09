package com.vladv.domain.usecase

import com.vladv.domain.model.ModelProbe
import com.vladv.domain.repository.RepositoryGet

class GetFullProbeUseCase (private val repository: RepositoryGet) {
    suspend fun execute(): List<ModelProbe> {
        return repository.getFullProb()
    }
}