package com.vladv.testlocalbase.di

import com.vladv.domain.usecase.FirestoreUseCase
import com.vladv.domain.usecase.GetFullProbeUseCase
import com.vladv.domain.usecase.GetFullUnitUseCase
import com.vladv.domain.usecase.GetProbeUseCase
import com.vladv.domain.usecase.GetRecordUseCase
import com.vladv.domain.usecase.GetUnitUseCase
import com.vladv.domain.usecase.SaveProbeUseCase
import com.vladv.domain.usecase.SaveRecordUseCase
import com.vladv.domain.usecase.SaveUnitUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetRecordUseCase> {
        GetRecordUseCase(
            repository = get()
        )
    }

    factory<SaveUnitUseCase> {
        SaveUnitUseCase(
            repositorySave = get()
        )
    }
    factory<SaveProbeUseCase> {
        SaveProbeUseCase(
            repositorySave = get()
        )
    }

    factory<SaveRecordUseCase> {
        SaveRecordUseCase(
            repositorySave = get()
        )
    }
    factory<GetProbeUseCase> {
        GetProbeUseCase(
            repository = get()
        )
    }
    factory<GetUnitUseCase> {
        GetUnitUseCase(
            repository = get()
        )
    }
    factory<GetFullProbeUseCase> {
        GetFullProbeUseCase(
            repository = get()
        )
    }

    factory<GetFullUnitUseCase> {
        GetFullUnitUseCase(
            repository = get()
        )
    }
    factory<FirestoreUseCase> {
        FirestoreUseCase(
            repositoryFirestore = get()
        )
    }
}