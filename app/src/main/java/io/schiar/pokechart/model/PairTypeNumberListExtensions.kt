package io.schiar.pokechart.model

val List<Pair<Type, Number>>.types: List<Type> get() { return map { (type) -> type } }

fun List<Pair<Type, Number>>.decreaseRatioOrRemoveIfContainsIn(
    other: List<Pair<Type, Number>>
): List<Pair<Type, Number>> {
    return mapNotNull { (type, ratio) ->
        var newRatio = ratio.toDouble()
        val otherTypeIndex = other.types.indexOf(type)
        if (otherTypeIndex != -1) {
            val otherRatio = other[otherTypeIndex].second.toDouble()
            newRatio -= otherRatio
            if (newRatio <= 0.0) return@mapNotNull null
        }
        Pair(type, newRatio)
    }
}

fun List<Pair<Type, Number>>.increaseRatioAndRemoveDuplicates(): List<Pair<Type, Number>> {
    return mutableListOf<Pair<Type, Number>>().apply {
        for (typeAndRatio in this@increaseRatioAndRemoveDuplicates) {
            val (type, ratio) = typeAndRatio
            val ratioDouble = ratio.toDouble()
            val indexOfTypeAndRatio = this.types.indexOf(type)
            if (indexOfTypeAndRatio != -1) {
                val (_, duplicateRatio) = this[indexOfTypeAndRatio]
                val duplicateRatioDouble = duplicateRatio.toDouble()
                this[indexOfTypeAndRatio] = Pair(type, duplicateRatioDouble + ratioDouble)
                continue
            }
            add(typeAndRatio)
        }
    }
}

fun List<Pair<Type, Number>>.newResistantListConsidering(
    otherVulnerable: List<Pair<Type, Number>>,
    otherResistant: List<Pair<Type, Number>>
): List<Pair<Type, Number>> {
    return (
        decreaseRatioOrRemoveIfContainsIn(otherVulnerable) +
        otherResistant.decreaseRatioOrRemoveIfContainsIn(other = this)
    ).increaseRatioAndRemoveDuplicates()
}

fun List<Pair<Type, Number>>.newVulnerableListConsidering(
    otherVulnerable: List<Pair<Type, Number>>,
    otherResistant: List<Pair<Type, Number>>
): List<Pair<Type, Number>> {
    return (
        this.decreaseRatioOrRemoveIfContainsIn(otherResistant) +
        otherVulnerable.decreaseRatioOrRemoveIfContainsIn(other = this)
    ).increaseRatioAndRemoveDuplicates()
}