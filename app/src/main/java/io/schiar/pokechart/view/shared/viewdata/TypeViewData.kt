package io.schiar.pokechart.view.shared.viewdata

data class TypeViewData(
    val name: String,
    val strong: List<Pair<TypeViewData, String>> = emptyList(),
    val weak: List<Pair<TypeViewData, String>> = emptyList(),
    val resistant: List<Pair<TypeViewData, String>> = emptyList(),
    val vulnerable: List<Pair<TypeViewData, String>> = emptyList()
) {
    val names: List<String> = name.split(" ")
}