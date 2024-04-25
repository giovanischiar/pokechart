package io.schiar.pokechart.view.shared

import androidx.compose.ui.graphics.Color
import io.schiar.pokechart.R
import io.schiar.pokechart.view.shared.viewdata.TypeViewData

val TypeViewData.stringResourceID: Int get() {
    return when (name) {
        "Normal" -> R.string.normal
        "Fighting" -> R.string.fighting
        "Flying" -> R.string.flying
        "Poison" -> R.string.poison
        "Ground" -> R.string.ground
        "Rock" -> R.string.rock
        "Bug" -> R.string.bug
        "Ghost" -> R.string.ghost
        "Steel" -> R.string.steel
        "Fire" -> R.string.fire
        "Water" -> R.string.water
        "Grass" -> R.string.grass
        "Electric" -> R.string.electric
        "Psychic" -> R.string.psychic
        "Ice" -> R.string.ice
        "Dragon" -> R.string.dragon
        "Fairy" -> R.string.fairy
        "Dark" -> R.string.dark
        else -> R.string.normal
    }
}

val TypeViewData.iconResourceID: Int get() {
    return when (name) {
        "Normal" -> R.drawable.normal
        "Fighting" -> R.drawable.fighting
        "Flying" -> R.drawable.flying
        "Poison" -> R.drawable.poison
        "Ground" -> R.drawable.ground
        "Rock" -> R.drawable.rock
        "Bug" -> R.drawable.bug
        "Ghost" -> R.drawable.ghost
        "Steel" -> R.drawable.steel
        "Fire" -> R.drawable.fire
        "Water" -> R.drawable.water
        "Grass" -> R.drawable.grass
        "Electric" -> R.drawable.electric
        "Psychic" -> R.drawable.psychic
        "Ice" -> R.drawable.ice
        "Dragon" -> R.drawable.dragon
        "Fairy" -> R.drawable.fairy
        "Dark" -> R.drawable.dark
        else -> R.drawable.normal
    }
}

val TypeViewData.color: Color get() {
    return when (name) {
        "Normal" -> io.schiar.pokechart.view.shared.theme.normal
        "Fighting" -> io.schiar.pokechart.view.shared.theme.fighting
        "Flying" -> io.schiar.pokechart.view.shared.theme.flying
        "Poison" -> io.schiar.pokechart.view.shared.theme.poison
        "Ground" -> io.schiar.pokechart.view.shared.theme.ground
        "Rock" -> io.schiar.pokechart.view.shared.theme.rock
        "Bug" -> io.schiar.pokechart.view.shared.theme.bug
        "Ghost" -> io.schiar.pokechart.view.shared.theme.ghost
        "Steel" -> io.schiar.pokechart.view.shared.theme.steel
        "Fire" -> io.schiar.pokechart.view.shared.theme.fire
        "Water" -> io.schiar.pokechart.view.shared.theme.water
        "Grass" -> io.schiar.pokechart.view.shared.theme.grass
        "Electric" -> io.schiar.pokechart.view.shared.theme.electric
        "Psychic" -> io.schiar.pokechart.view.shared.theme.psychic
        "Ice" -> io.schiar.pokechart.view.shared.theme.ice
        "Dragon" -> io.schiar.pokechart.view.shared.theme.dragon
        "Fairy" -> io.schiar.pokechart.view.shared.theme.fairy
        "Dark" -> io.schiar.pokechart.view.shared.theme.dark
        else -> io.schiar.pokechart.view.shared.theme.normal
    }
}