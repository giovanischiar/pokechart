package io.schiar.pokechart.viewmodel.util

import io.schiar.pokechart.model.ResultType
import io.schiar.pokechart.model.Type
import io.schiar.pokechart.model.TypeEffectiveness
import io.schiar.pokechart.view.shared.viewdata.ResultTypeViewData
import io.schiar.pokechart.view.shared.viewdata.TypeEffectivenessViewData
import io.schiar.pokechart.view.shared.viewdata.TypeLayoutViewData
import io.schiar.pokechart.view.shared.viewdata.TypeViewData
import java.text.DecimalFormat

fun ResultType.toViewData(): ResultTypeViewData {
    return ResultTypeViewData(
        types = types.toViewDataList(),
        resistant = resistant.toTypeEffectivenessViewDataList(),
        vulnerable = vulnerable.toTypeEffectivenessViewDataList(),
        strong = strong.toTypeEffectivenessViewDataList(),
        weak = weak.toTypeEffectivenessViewDataList()
    )
}

fun Type.toViewData(): TypeViewData {
    return TypeViewData(name = name)
}

fun TypeEffectiveness.toViewData(): TypeEffectivenessViewData {
    val decimalFormat = DecimalFormat(decimalFormatForMultiplierPattern)
    return TypeEffectivenessViewData(
        type = type.toViewData(),
        multiplier = decimalFormat.format(multiplier)
    )
}

fun List<Type>.toViewDataList(): List<TypeViewData> {
    return map { type -> type.toViewData() }
}

fun List<TypeEffectiveness>.toTypeEffectivenessViewDataList(): List<TypeEffectivenessViewData> {
    return map { typeEffectiveness -> typeEffectiveness.toViewData() }
}

fun List<Type>.toTypeLayoutViewData(): TypeLayoutViewData {
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