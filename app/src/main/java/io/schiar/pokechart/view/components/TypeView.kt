package io.schiar.pokechart.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ButtonDefaults
import io.schiar.pokechart.view.color
import io.schiar.pokechart.view.iconResourceID
import io.schiar.pokechart.view.stringResourceID
import io.schiar.pokechart.view.viewdata.TypeViewData

@Composable
fun TypeView(
    modifier: Modifier = Modifier,
    type: TypeViewData,
    isSelected: Boolean = false,
    onPress: () -> Unit
) {
    IconButton(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSelected) Color.Gray else Color.Transparent
        ),
        border = ButtonDefaults.buttonBorder(borderStroke = BorderStroke(1.dp, Color.Gray)),
        iconResourceID = type.iconResourceID,
        contentDescriptionStringResourceID = type.stringResourceID,
        iconTint = type.color,
        onPress = onPress
    )
}