package com.vladv.localbasestore.presentation.dialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladv.domain.model.ModelProbe
import com.vladv.domain.usecase.GetFullProbeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DialogViewModel(getProbeUseCase: GetFullProbeUseCase): ViewModel() {
    private val _probeByFlow = MutableStateFlow<List<ModelProbe>>(listOf())
    val probeByFlow = _probeByFlow.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            _probeByFlow.value = getProbeUseCase.execute()
        }
    }
}