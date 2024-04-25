package io.schiar.pokechart.model

data class Type(
    val name: String,
    val strong: List<Type> = emptyList(),
    val weak: List<Type> = emptyList(),
    val resistant: List<Pair<Type, Int>> = emptyList(),
    val vulnerable: List<Pair<Type, Int>> = emptyList()
): Comparable<Type> {
    fun strongAgainst(vararg types: Type): Type {
        return Type(
            name = name,
            strong = types.asList() + strong,
            weak = weak,
            resistant = resistant,
            vulnerable = vulnerable
        )
    }

    fun weakAgainst(vararg types: Type): Type {
        return Type(
            name = name,
            strong = strong,
            weak = types.asList() + weak,
            resistant = resistant,
            vulnerable = vulnerable
        )
    }

    fun resistantTo(vararg types: Type): Type {
        return Type(
            name = name,
            strong = strong,
            weak = weak,
            resistant = types.map { type -> Pair(type, 1) } + resistant,
            vulnerable = vulnerable
        )
    }

    fun vulnerableTo(vararg types: Type): Type {
        return Type(
            name = name,
            strong = strong,
            weak = weak,
            resistant = resistant,
            vulnerable = types.map { type -> Pair(type, 1) } + vulnerable
        )
    }

    operator fun plus(other: Type): Type {
        return Type(
            name = name + " " + other.name,
            strong = strong + other.strong,
            weak = weak + other.weak,
            resistant = calculateNewResistantList(
                otherVulnerable = other.vulnerable,
                otherResistant = other.resistant
            ).sortedBy { (type) -> type },
            vulnerable = calculateNewVulnerableList(
                otherVulnerable = other.vulnerable,
                otherResistant = other.resistant
            ).sortedBy { (type) -> type }
        )
    }

    override fun compareTo(other: Type): Int {
        return name.compareTo(other.name)
    }

    private val List<Pair<Type, Int>>.types: List<Type> get() { return map { (type) -> type } }

    private fun calculateNewResistantList(
        otherVulnerable: List<Pair<Type, Int>>,
        otherResistant: List<Pair<Type, Int>>
    ): List<Pair<Type, Int>> {
        return (
            this.resistant.decreaseRatio(otherVulnerable) +
            otherResistant.decreaseRatio(this.vulnerable)
        ).increaseRatioIfDuplicated()
    }

    private fun calculateNewVulnerableList(
        otherVulnerable: List<Pair<Type, Int>>,
        otherResistant: List<Pair<Type, Int>>
    ): List<Pair<Type, Int>> {
        return (
            this.vulnerable.decreaseRatio(otherResistant) +
            otherVulnerable.decreaseRatio(this.resistant)
        ).increaseRatioIfDuplicated()
    }

    private fun List<Pair<Type, Int>>.decreaseRatio(
        other: List<Pair<Type, Int>>
    ): List<Pair<Type, Int>> {
        return map { (type, ratio) ->
            var newRatio = ratio
            if (other.types.contains(type)) { newRatio-- }
            Pair(type, newRatio)
        }
    }

    private fun List<Pair<Type, Int>>.increaseRatioIfDuplicated(): List<Pair<Type, Int>> {
        return mutableListOf<Pair<Type, Int>>().apply {
            for (typeAndRatio in this@increaseRatioIfDuplicated) {
                val (type, ratio) = typeAndRatio
                if (ratio == 0) continue
                val indexOfTypeAndRatio = this.types.indexOf(type)
                if (indexOfTypeAndRatio != -1) {
                    this[indexOfTypeAndRatio] = Pair(type, ratio + 1)
                    continue
                }
                add(typeAndRatio)
            }
        }
    }
}