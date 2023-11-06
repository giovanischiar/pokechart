package io.schiar.pokechart.model

data class Type(
    val name: String,
    val strong: List<Type> = emptyList(),
    val weak: List<Type> = emptyList(),
    val resistant: List<Type> = emptyList(),
    val vulnerable: List<Type> = emptyList()
) {
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
            resistant = types.asList() + resistant,
            vulnerable = vulnerable
        )
    }

    fun vulnerableTo(vararg types: Type): Type {
        return Type(
            name = name,
            strong = strong,
            weak = weak,
            resistant = resistant,
            vulnerable = types.asList() + vulnerable
        )
    }
}