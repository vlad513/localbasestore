package com.vladv.localbasestore.presentation.add.record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.vladv.domain.model.ModelRecord
import com.vladv.domain.usecase.GetProbeUseCase
import com.vladv.domain.usecase.GetUnitUseCase
import com.vladv.domain.usecase.SaveRecordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecordViewModel(
    private val saveRecordUseCase: SaveRecordUseCase,
    private val getProbeUseCase: GetProbeUseCase,
    private val getUnitUseCase: GetUnitUseCase,
) : ViewModel() {
    private val _unitByFlow = MutableStateFlow<List<Int>>(listOf())
    val unitByFlow = _unitByFlow.asStateFlow()

    private val _probeByFlow = MutableStateFlow<List<Int>>(listOf())
    val probeByFlow = _probeByFlow.asStateFlow()

    fun saveRecord(record: ModelRecord) {
        viewModelScope.launch(Dispatchers.IO) {
            saveRecordUseCase.execute(record = record)
        }
    }

    fun getProbe() {
        viewModelScope.launch(Dispatchers.IO) {
            _probeByFlow.value = getProbeUseCase.execute()
        }
    }

    fun getUnit() {
        viewModelScope.launch(Dispatchers.IO) {
            _unitByFlow.value = getUnitUseCase.execute()
        }
    }
}