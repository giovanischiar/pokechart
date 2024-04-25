package io.schiar.pokechart.viewmodel

import io.schiar.pokechart.model.Type
import io.schiar.pokechart.view.viewdata.TypeViewData
import io.schiar.pokechart.view.viewdata.TypesViewData

fun Type.toViewData(): TypeViewData {
    return TypeViewData(
        name = name,
        strong = strong.map { it.toViewData() },
        weak = weak.map { it.toViewData() },
        resistant = resistant.map { it.toViewData() },
        vulnerable = vulnerable.map { it.toViewData() }
    )
}

fun List<Type>.toViewDataList(): List<TypeViewData> {
    return map { type -> type.toViewData() }
}

fun List<Type>.toTypesViewData(): TypesViewData {
    if (size < upperRowTypeSize) return TypesViewData()
    val lastRowOffset = size - 1
    val upperRowTypes = subList(0, upperRowTypeSize)
    val centralRowsTypes = subList(upperRowTypeSize, lastRowOffset)
    val lowerRowTypes = subList(lastRowOffset, size)

    return TypesViewData(
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