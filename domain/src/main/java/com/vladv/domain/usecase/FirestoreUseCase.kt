package com.vladv.domain.usecase

import com.vladv.domain.model.ModelUnit
import com.vladv.domain.repository.RepositoryFirestore

class FirestoreUseCase(private val repositoryFirestore: RepositoryFirestore) {
    suspend fun execute(unit:List<ModelUnit>){
        repositoryFirestore.addUnit(unit = unit)
    }

}