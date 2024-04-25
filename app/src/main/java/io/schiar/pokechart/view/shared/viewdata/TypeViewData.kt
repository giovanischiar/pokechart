package io.schiar.pokechart.view.shared.viewdata

data class TypeViewData(
    val name: String,
    val strong: List<Pair<TypeViewData, Int>> = emptyList(),
    val weak: List<Pair<TypeViewData, Int>> = emptyList(),
    val resistant: List<Pair<TypeViewData, Int>> = emptyList(),
    val vulnerable: List<Pair<TypeViewData, Int>> = emptyList()
) {
    val names: List<String> = name.split(" ")
}