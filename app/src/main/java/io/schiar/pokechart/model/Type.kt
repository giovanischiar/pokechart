package io.schiar.pokechart.model

data class Type(
    val name: String,
    val strong: List<Type> = emptyList(),
    val weak: List<Type> = emptyList(),
    val resistant: List<Pair<Type, Number>> = emptyList(),
    val vulnerable: List<Pair<Type, Number>> = emptyList(),
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
            resistant = (types.map { type -> Pair(type, 1) } + resistant)
                .sortedBy { (type) -> type },
            vulnerable = vulnerable.sortedBy { (type) -> type }
        )
    }

    fun vulnerableTo(vararg types: Type): Type {
        return Type(
            name = name,
            strong = strong,
            weak = weak,
            resistant = resistant,
            vulnerable = (types.map { type -> Pair(type, 1) } + vulnerable)
                .sortedBy { (type) -> type }
        )
    }

    fun immuneTo(vararg types: Type): Type {
        return Type(
            name = name,
            strong = strong,
            weak = weak,
            resistant = (types.map { type -> Pair(type, 2) } + resistant)
                .sortedBy { (type) -> type },
            vulnerable = vulnerable
        )
    }

    operator fun plus(other: Type): Type {
        return Type(
            name = name + " " + other.name,
            strong = strong + other.strong,
            weak = weak + other.weak,
            resistant = resistant.newResistantListConsidering(
                otherVulnerable = other.vulnerable,
                otherResistant = other.resistant
            ).sortedBy { (type) -> type },
            vulnerable = vulnerable.newVulnerableListConsidering(
                otherVulnerable = other.vulnerable,
                otherResistant = other.resistant
            ).sortedBy { (type) -> type }
        )
    }

    override fun compareTo(other: Type): Int {
        return name.compareTo(other.name)
    }
}