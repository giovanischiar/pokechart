package io.schiar.pokechart.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import io.schiar.pokechart.view.color
import io.schiar.pokechart.view.iconResourceID
import io.schiar.pokechart.view.viewdata.TypeViewData

@Composable
fun TypeView(
    modifier: Modifier = Modifier,
    type: TypeViewData,
    isSelected: Boolean = false,
    onPressed: () -> Unit
) {
    Button(
        modifier = modifier.padding(all = 3.dp).size(30.dp),
        onClick = onPressed,
        border = ButtonDefaults.buttonBorder(
            borderStroke = BorderStroke(1.dp, Color.Gray)
        ),
        colors = ButtonDefaults
            .buttonColors(backgroundColor = if (isSelected) Color.Gray else Color.Transparent)
    ) {
        Icon(
            modifier = Modifier.padding(all = 4.dp),
            painter = painterResource(id = type.iconResourceID()),
            contentDescription = type.name,
            tint = type.color()
        )
    }
}