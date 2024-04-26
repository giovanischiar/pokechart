package io.schiar.pokechart.viewmodel

import io.schiar.pokechart.model.Type
import io.schiar.pokechart.view.shared.viewdata.TypeLayoutViewData
import io.schiar.pokechart.view.shared.viewdata.TypeViewData
import java.text.DecimalFormat

fun Type.toViewData(): TypeViewData {
    return TypeViewData(
        name = name,
        strong = strong.toViewDataPairList(),
        weak = weak.toViewDataPairList(),
        resistant = resistant.toViewDataPairList(),
        vulnerable = vulnerable.toViewDataPairList()
    )
}

fun List<Any>.toViewDataPairList(): List<Pair<TypeViewData, String>> {
    if (this.isEmpty()) return emptyList()
    val decimalFormat = DecimalFormat("#.###")
    return when (this[0]) {
        is Type -> map { type -> Pair((type as Type).toViewData(), "1") }
        is Pair<*, *> -> map { it as Pair<*, *> }
            .map { (type, ratio) -> Pair((type as Type).toViewData(), decimalFormat.format(ratio)) }
        else -> emptyList()
    }
}

fun List<Type>.toTypesViewData(): TypeLayoutViewData {
    if (size < upperRowTypeSize) return TypeLayoutViewData()
    val lastRowOffset = size - 1
    val upperRowTypes = subList(0, upperRowTypeSize)
    val centralRowsTypes = subList(upperRowTypeSize, lastRowOffset)
    val lowerRowTypes = subList(lastRowOffset, size)

    return TypeLayoutViewData(
        upperRow = upperRowTypes.mapIndexed { index, type -> Pair(index, type.toViewData()) },
        centralRows = centralRowsTypes.mapIndexed { index, type ->
            val indexFromTypesList = index + upperRowTypeSize
            Pair(indexFromTypesList, type.toViewData())
        },
        lowerRow = lowerRowTypes.mapIndexed { index, type ->
            val indexFromTypesList = index + lastRowOffset
            Pair(indexFromTypesList, type.toViewData())
        },
    )
}