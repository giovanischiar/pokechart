package io.schiar.pokechart.model

import org.junit.Assert
import org.junit.Test

class TypeEffectivenessListTest {
    @Test
    fun `Two types when one of them is immune and another one is vulnerable to the same type`() {
        var typeA = Type(name = "typeA")
        var typeB = Type(name = "typeB")

        typeA = typeA.immuneTo(typeB)
        typeB = typeB.vulnerableTo(typeB)

        val typeEffectiveness = TypeEffectiveness(type = Type(name = "typeB"), multiplier = 1.0)

        Assert.assertTrue((typeA + typeB).resistant.contains(typeEffectiveness))
    }

    @Test
    fun `Two types when one of them is resistant and another one is vulnerable to the same type`() {
        var typeA = Type(name = "typeA")
        var typeB = Type(name = "typeB")

        typeA = typeA.resistantTo(typeB)
        typeB = typeB.vulnerableTo(typeB)

        Assert.assertTrue((typeA + typeB).resistant.isEmpty())
    }

    @Test
    fun `Two types when each one have a different resistant type`() {
        var typeA = Type(name = "typeA")
        var typeB = Type(name = "typeB")
        val typeC = Type(name = "typeC")
        val typeD = Type(name = "typeD")

        typeA = typeA.resistantTo(typeC)
        typeB = typeB.resistantTo(typeD)

        val typeEffectiveness = listOf(
            TypeEffectiveness(type = typeC, multiplier = 1.0),
            TypeEffectiveness(type = typeD, multiplier = 1.0),
        )

        Assert.assertEquals(
            (typeA + typeB).resistant
                .map { TypeEffectiveness(it.type, it.multiplier.toDouble()) },
                    typeEffectiveness
        )
    }

    @Test
    fun `Two types when both have the same resistant type`() {
        var typeA = Type(name = "typeA")
        var typeB = Type(name = "typeB")
        val typeC = Type(name = "typeC")

        typeA = typeA.resistantTo(typeC)
        typeB = typeB.resistantTo(typeC)

        val typeEffectiveness = TypeEffectiveness(type = Type(name = "typeC"), multiplier = 2.0)

        Assert.assertTrue((typeA + typeB).resistant.contains(typeEffectiveness))
    }

    @Test
    fun `Two types when both have the same vulnerable type`() {
        var typeA = Type(name = "typeA")
        var typeB = Type(name = "typeB")
        val typeC = Type(name = "typeC")

        typeA = typeA.vulnerableTo(typeC)
        typeB = typeB.vulnerableTo(typeC)

        val typeEffectiveness = TypeEffectiveness(type = Type(name = "typeC"), multiplier = 2.0)

        Assert.assertTrue((typeA + typeB).vulnerable.contains(typeEffectiveness))
    }

    @Test
    fun `Two types when one of them is immune and another one is resistant to the same type`() {
        var typeA = Type(name = "typeA")
        var typeB = Type(name = "typeB")

        typeA = typeA.immuneTo(typeB)
        typeB = typeB.resistantTo(typeB)

        val typeEffectiveness = TypeEffectiveness(type = Type(name = "typeB"), multiplier = 3.0)

        Assert.assertTrue((typeA + typeB).resistant.contains(typeEffectiveness))
    }

    @Test
    fun `Two types when both of them are immune to the same type`() {
        var typeA = Type(name = "typeA")
        var typeB = Type(name = "typeB")

        typeA = typeA.immuneTo(typeB)
        typeB = typeB.immuneTo(typeB)

        val typeEffectiveness = TypeEffectiveness(type = Type(name = "typeB"), multiplier = 4.0)

        Assert.assertTrue((typeA + typeB).resistant.contains(typeEffectiveness))
    }
}