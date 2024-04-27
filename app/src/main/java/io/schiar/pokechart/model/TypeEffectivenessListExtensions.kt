package io.schiar.pokechart.model

val List<TypeEffectiveness>.types: List<Type> get() { return map { (type) -> type } }

fun List<TypeEffectiveness>.decreaseMultiplierOrRemoveIfContainsIn(
    other: List<TypeEffectiveness>
): List<TypeEffectiveness> {
    return mapNotNull { typeEffectiveness ->
        var newTypeEffectiveness: TypeEffectiveness? = typeEffectiveness
        val otherTypeIndex = other.types.indexOf(typeEffectiveness.type)
        if (otherTypeIndex != -1) {
            newTypeEffectiveness = typeEffectiveness - other[otherTypeIndex]
        }
        newTypeEffectiveness
    }
}

fun List<TypeEffectiveness>.increaseMultiplierAndRemoveDuplicates(): List<TypeEffectiveness> {
    return mutableListOf<TypeEffectiveness>().apply {
        for (typeEffectiveness in this@increaseMultiplierAndRemoveDuplicates) {
            val indexOfTypeEffectiveness = this.types.indexOf(typeEffectiveness.type)
            if (indexOfTypeEffectiveness != -1) {
                this[indexOfTypeEffectiveness] = this[indexOfTypeEffectiveness] + typeEffectiveness
                continue
            }
            add(typeEffectiveness)
        }
    }
}

fun List<TypeEffectiveness>.newResistantListConsidering(
    vulnerable: List<TypeEffectiveness>,
    otherVulnerable: List<TypeEffectiveness>,
    otherResistant: List<TypeEffectiveness>
): List<TypeEffectiveness> {
    return (
        decreaseMultiplierOrRemoveIfContainsIn(otherVulnerable) +
        otherResistant.decreaseMultiplierOrRemoveIfContainsIn(other = vulnerable)
    ).increaseMultiplierAndRemoveDuplicates()
}

fun List<TypeEffectiveness>.newVulnerableListConsidering(
    resistant: List<TypeEffectiveness>,
    otherVulnerable: List<TypeEffectiveness>,
    otherResistant: List<TypeEffectiveness>
): List<TypeEffectiveness> {
    return (
        decreaseMultiplierOrRemoveIfContainsIn(otherResistant) +
        otherVulnerable.decreaseMultiplierOrRemoveIfContainsIn(other = resistant)
    ).increaseMultiplierAndRemoveDuplicates()
}