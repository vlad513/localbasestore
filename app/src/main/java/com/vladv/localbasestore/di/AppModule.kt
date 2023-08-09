package com.vladv.testlocalbase.di



import com.vladv.localbasestore.presentation.add.probe.ProbeViewModel
import com.vladv.localbasestore.presentation.add.record.RecordViewModel
import com.vladv.localbasestore.presentation.add.unit.ViewModelUnit
import com.vladv.localbasestore.presentation.addfirestore.FireStoreViewModel
import com.vladv.localbasestore.presentation.dialog.DialogViewModel
import com.vladv.localbasestore.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getRecordUseCase = get()
        )
    }

    viewModel<ViewModelUnit> {
        ViewModelUnit(
            saveUnitUseCase = get()
        )
    }
    viewModel<ProbeViewModel> {
        ProbeViewModel(
            saveProbeUseCase = get()
        )
    }
    viewModel<RecordViewModel> {
        RecordViewModel(
            saveRecordUseCase = get(),
            getProbeUseCase = get(),
            getUnitUseCase = get()
        )
    }
    viewModel<DialogViewModel> {
        DialogViewModel(
            getProbeUseCase = get()
        )
    }
    viewModel<FireStoreViewModel> {
        FireStoreViewModel(
            getFullUnitUseCase = get(),
            getRecordUseCase = get(),
            getFullProbeUseCase = get()
        )
    }
}