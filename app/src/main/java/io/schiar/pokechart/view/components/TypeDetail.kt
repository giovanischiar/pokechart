package io.schiar.pokechart.view.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import io.schiar.pokechart.view.color
import io.schiar.pokechart.view.iconCode
import io.schiar.pokechart.view.viewdata.TypeViewData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TypeDetail(types: List<TypeViewData>, titleID: Int) {
    TitleCard(
        onClick = {},
        title = { Text(stringResource(titleID)) },
        contentColor = MaterialTheme.colors.onSurface
    ) {
        FlowRow {
            types.map { type ->
                Icon(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    painter = painterResource(type.iconCode()),
                    contentDescription = type.name,
                    tint = type.color()
                )
            }
        }
    }
}