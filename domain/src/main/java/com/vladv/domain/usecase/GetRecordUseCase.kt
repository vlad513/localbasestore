package com.vladv.domain.usecase

import com.vladv.domain.repository.RepositoryGet
import com.vladv.domain.model.ModelRecord


class GetRecordUseCase(private val repository: RepositoryGet) {
    suspend fun execute(): List<ModelRecord> {
        return repository.getRecord()
    }
}