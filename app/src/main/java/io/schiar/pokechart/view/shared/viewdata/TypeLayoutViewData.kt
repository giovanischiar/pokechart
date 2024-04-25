package io.schiar.pokechart.view.shared.viewdata

data class TypeLayoutViewData(
    val upperRow: List<Pair<Int, TypeViewData>> = emptyList(),
    val centralRows: List<Pair<Int, TypeViewData>> = emptyList(),
    val lowerRow: List<Pair<Int, TypeViewData>> = emptyList()
) {
    fun isEmpty(): Boolean {
        return upperRow.isEmpty() && centralRows.isEmpty() && lowerRow.isEmpty()
    }
}