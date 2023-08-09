package com.vladv.localbasestore.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.usecase.GetRecordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getRecordUseCase: GetRecordUseCase

) : ViewModel() {
    private val _recordByFlow = MutableStateFlow<List<ModelRecord>>(listOf())
    val recordByFlow = _recordByFlow.asStateFlow()

    fun getRecord() {
        viewModelScope.launch(Dispatchers.IO) {
            _recordByFlow.value = getRecordUseCase.execute()
        }
    }

}