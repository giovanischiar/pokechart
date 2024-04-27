package io.schiar.pokechart.view.shared.viewdata

data class ResultTypeViewData(
    val types: List<TypeViewData>,
    val resistant: List<TypeEffectivenessViewData> = emptyList(),
    val vulnerable: List<TypeEffectivenessViewData> = emptyList(),
    val strong: List<TypeEffectivenessViewData> = emptyList(),
    val weak: List<TypeEffectivenessViewData> = emptyList()
)
