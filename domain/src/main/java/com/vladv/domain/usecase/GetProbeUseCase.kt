package com.vladv.domain.usecase

import com.vladv.domain.repository.RepositoryGet

class GetProbeUseCase (private val repository: RepositoryGet) {
    suspend fun execute(): List<Int> {
        return repository.getProb()
    }
}