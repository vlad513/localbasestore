package com.vladv.localbasestore.presentation.addfirestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladv.domain.model.ModelProbe
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.model.ModelUnit
import com.vladv.domain.usecase.FirestoreUseCase
import com.vladv.domain.usecase.GetFullProbeUseCase
import com.vladv.domain.usecase.GetFullUnitUseCase
import com.vladv.domain.usecase.GetRecordUseCase
import com.vladv.domain.usecase.GetUnitUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FireStoreViewModel(
    private val getFullUnitUseCase: GetFullUnitUseCase,
    private val getFullProbeUseCase: GetFullProbeUseCase,
    private val getRecordUseCase: GetRecordUseCase

) : ViewModel() {
    private val _unitByFlow = MutableStateFlow<List<ModelUnit>>(listOf())
    val unitByFlow = _unitByFlow.asStateFlow()

    private val _probeByFlow = MutableStateFlow<List<ModelProbe>>(listOf())
    val probeByFlow = _probeByFlow.asStateFlow()

    private val _recordByFlow = MutableStateFlow<List<ModelRecord>>(listOf())
    val recordByFlow = _recordByFlow.asStateFlow()


    fun getUnit() {
        viewModelScope.launch(Dispatchers.IO) {
            _unitByFlow.value = getFullUnitUseCase.execute()
        }
    }

    fun getProbe() {
        viewModelScope.launch(Dispatchers.IO) {
            _probeByFlow.value = getFullProbeUseCase.execute()
        }
    }

    fun getRecord() {
        viewModelScope.launch(Dispatchers.IO) {
            _recordByFlow.value = getRecordUseCase.execute()
        }
    }
}