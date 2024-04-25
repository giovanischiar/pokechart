package io.schiar.pokechart.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import io.schiar.pokechart.view.color
import io.schiar.pokechart.view.iconResourceID
import io.schiar.pokechart.view.stringResourceID
import io.schiar.pokechart.view.viewdata.TypeViewData

@Composable
fun TypesBar(typeNames: List<String>) {
    Box(
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Row {
            typeNames.map { typeName ->
                val type = TypeViewData(name = typeName)
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = type.iconResourceID),
                    contentDescription = stringResource(id = type.stringResourceID),
                    tint = type.color
                )
            }
        }
    }
}