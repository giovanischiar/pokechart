package io.schiar.pokechart.viewmodel

import io.schiar.pokechart.model.Type
import io.schiar.pokechart.view.viewdata.TypeViewData

fun Type.toViewData(): TypeViewData {
    return TypeViewData(
        name = name,
        strong = strong.map { it.toViewData() },
        weak = weak.map { it.toViewData() },
        resistant = resistant.map { it.toViewData() },
        vulnerable = vulnerable.map { it.toViewData() }
    )
}