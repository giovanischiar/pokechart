package io.schiar.pokechart.view.viewdata

data class TypeViewData(
    val name: String,
    val strong: List<TypeViewData> = emptyList(),
    val weak: List<TypeViewData> = emptyList(),
    val resistant: List<TypeViewData> = emptyList(),
    val vulnerable: List<TypeViewData> = emptyList()
)