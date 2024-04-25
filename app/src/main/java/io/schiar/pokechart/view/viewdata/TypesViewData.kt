package io.schiar.pokechart.view.viewdata

data class TypesViewData(
    val upperRow: List<Pair<Int, TypeViewData>> = emptyList(),
    val centralRows: List<Pair<Int, TypeViewData>> = emptyList(),
    val lowerRow: List<Pair<Int, TypeViewData>> = emptyList()
) {
    fun isEmpty(): Boolean {
        return upperRow.isEmpty() && centralRows.isEmpty() && lowerRow.isEmpty()
    }
}