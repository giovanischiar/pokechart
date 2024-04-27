package io.schiar.pokechart.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.schiar.pokechart.model.repository.ResultTypeRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ResultTypeViewModel @Inject constructor(
     currentTypesRepository: ResultTypeRepository
): ViewModel() {
    val resultTypeFlow = currentTypesRepository.resultTypeFlow.map { resultType ->
        resultType.toViewData()
    }
}