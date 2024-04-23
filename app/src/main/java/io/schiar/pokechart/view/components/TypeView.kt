package io.schiar.pokechart.view.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import io.schiar.pokechart.view.color
import io.schiar.pokechart.view.iconCode
import io.schiar.pokechart.view.viewdata.TypeViewData

@Composable
fun TypeView(
    modifier: Modifier = Modifier,
    type: TypeViewData,
    onPressed: () -> Unit
) {
    Button(
        modifier = modifier
            .padding(all = 3.dp)
            .width(30.dp)
            .height(30.dp),
        onClick = onPressed
    ) {
        Icon(
            modifier = Modifier.padding(all = 4.dp),
            painter = painterResource(type.iconCode()),
            contentDescription = type.name,
            tint = type.color()
        )
    }
}