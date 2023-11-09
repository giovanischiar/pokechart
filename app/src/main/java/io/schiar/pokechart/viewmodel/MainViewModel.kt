package io.schiar.pokechart.viewmodel

import io.schiar.pokechart.model.repository.Repository
import io.schiar.pokechart.model.repository.TypeRepository
import io.schiar.pokechart.view.viewdata.TypeViewData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(private val repository: Repository = TypeRepository()) {
    private var _types = MutableStateFlow(repository.types.map { it.toViewData() })
    val types: StateFlow<List<TypeViewData>> = _types.asStateFlow()
    private var _currentTypes = MutableStateFlow(repository.currentTypes.map { it.toViewData() })
    val currentTypes: StateFlow<List<TypeViewData>> = _currentTypes.asStateFlow()

    fun addCurrentType(typeName: String) {
        repository.addCurrentType(typeName = typeName)
        _currentTypes.update { repository.currentTypes.map { it.toViewData() } }
    }
}