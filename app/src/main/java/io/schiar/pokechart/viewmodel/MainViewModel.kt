package io.schiar.pokechart.viewmodel

import io.schiar.pokechart.model.repository.Repository
import io.schiar.pokechart.model.repository.TypeRepository
import io.schiar.pokechart.view.viewdata.TypeViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(repository: Repository = TypeRepository()) {
    private var _types = MutableStateFlow(repository.types.map { it.toViewData() })
    val types: StateFlow<List<TypeViewData>> = _types.asStateFlow()
}