package com.vladv.localbasestore.presentation.add.probe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladv.domain.model.ModelProbe
import com.vladv.domain.usecase.SaveProbeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProbeViewModel(private val saveProbeUseCase: SaveProbeUseCase) : ViewModel() {
    fun saveProbe(probe: ModelProbe) {
        viewModelScope.launch(Dispatchers.IO) {
            saveProbeUseCase.execute(probe = probe)
        }
    }
}