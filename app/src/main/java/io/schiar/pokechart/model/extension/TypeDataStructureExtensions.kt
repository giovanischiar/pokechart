package io.schiar.pokechart.model.extension

import io.schiar.pokechart.model.ResultType
import io.schiar.pokechart.model.Type
import io.schiar.pokechart.model.TypeEffectiveness

fun Collection<Type>.asResultType(): ResultType {
    return fold(initial = ResultType()) { acc, type -> acc + type }
}

fun Array<out Type>.asTypeEffectivenessList(multiplier: Number = 1): List<TypeEffectiveness> {
    return map { type -> TypeEffectiveness(type, multiplier) }
}

fun Collection<Type>.asTypeEffectivenessList(multiplier: Number = 1): List<TypeEffectiveness> {
    return toTypedArray().asTypeEffectivenessList(multiplier)
}
