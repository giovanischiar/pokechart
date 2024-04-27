package io.schiar.pokechart.view.resulttype.component

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
import io.schiar.pokechart.view.shared.color
import io.schiar.pokechart.view.shared.iconResourceID
import io.schiar.pokechart.view.shared.stringResourceID
import io.schiar.pokechart.view.shared.viewdata.TypeViewData

@Composable
fun TypesBar(types: List<TypeViewData>) {
    Box(
        modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Row {
            types.map { type ->
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