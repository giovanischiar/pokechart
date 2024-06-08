package io.schiar.pokechart.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.schiar.pokechart.model.repository.ResultTypeRepository
import io.schiar.pokechart.view.resulttype.ResultTypeUiState
import io.schiar.pokechart.viewmodel.util.toViewData
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ResultTypeViewModel @Inject constructor(
     currentTypesRepository: ResultTypeRepository
): ViewModel() {
    val resultTypeUiStateFlow = currentTypesRepository.resultTypeFlow.map { resultType ->
        ResultTypeUiState.ResultTypeLoaded(resultType.toViewData())
    }
}