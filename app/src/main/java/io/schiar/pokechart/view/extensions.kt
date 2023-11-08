package io.schiar.pokechart.view

import androidx.compose.ui.graphics.Color
import io.schiar.pokechart.R
import io.schiar.pokechart.view.theme.bug
import io.schiar.pokechart.view.theme.dark
import io.schiar.pokechart.view.theme.dragon
import io.schiar.pokechart.view.theme.electric
import io.schiar.pokechart.view.theme.fairy
import io.schiar.pokechart.view.theme.fighting
import io.schiar.pokechart.view.theme.fire
import io.schiar.pokechart.view.theme.flying
import io.schiar.pokechart.view.theme.ghost
import io.schiar.pokechart.view.theme.grass
import io.schiar.pokechart.view.theme.ground
import io.schiar.pokechart.view.theme.ice
import io.schiar.pokechart.view.theme.normal
import io.schiar.pokechart.view.theme.poison
import io.schiar.pokechart.view.theme.psychic
import io.schiar.pokechart.view.theme.rock
import io.schiar.pokechart.view.theme.steel
import io.schiar.pokechart.view.theme.water
import io.schiar.pokechart.view.viewdata.TypeViewData

fun TypeViewData.iconCode(): Int {
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

fun TypeViewData.color(): Color {
    return when (name) {
        "Normal" -> normal
        "Fighting" -> fighting
        "Flying" -> flying
        "Poison" -> poison
        "Ground" -> ground
        "Rock" -> rock
        "Bug" -> bug
        "Ghost" -> ghost
        "Steel" -> steel
        "Fire" -> fire
        "Water" -> water
        "Grass" -> grass
        "Electric" -> electric
        "Psychic" -> psychic
        "Ice" -> ice
        "Dragon" -> dragon
        "Fairy" -> fairy
        "Dark" -> dark
        else -> normal
    }
}