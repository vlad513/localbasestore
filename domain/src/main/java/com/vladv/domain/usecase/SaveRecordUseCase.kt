package com.vladv.domain.usecase

import com.vladv.domain.model.ModelRecord
import com.vladv.domain.repository.RepositorySave

class SaveRecordUseCase (private val repositorySave: RepositorySave) {
    suspend fun execute(record: ModelRecord) {
        repositorySave.saveRecord(record = record)
    }
}