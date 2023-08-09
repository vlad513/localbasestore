package com.vladv.localbasestore.presentation.add.unit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladv.domain.model.ModelUnit
import com.vladv.domain.usecase.SaveUnitUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelUnit(private val saveUnitUseCase: SaveUnitUseCase) : ViewModel() {
    fun saveUnit(unit: ModelUnit) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUnitUseCase.execute(unit = unit)
        }
    }

}