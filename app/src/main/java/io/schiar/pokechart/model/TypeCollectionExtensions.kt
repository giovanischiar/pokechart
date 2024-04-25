package io.schiar.pokechart.model

fun Collection<Type>.asType(): Type {
    return reduce { acc, type -> acc + type }
}