package io.schiar.pokechart.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TitleCard
import io.schiar.pokechart.view.color
import io.schiar.pokechart.view.iconResourceID
import io.schiar.pokechart.view.stringResourceID
import io.schiar.pokechart.view.viewdata.TypeViewData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TypeDetail(types: List<TypeViewData>, titleID: Int) {
    val typesDrawn = remember { mutableListOf<TypeViewData>() }
    val typesGrouped = remember { types.groupBy { it.name }.mapValues { it.value.size } }

    TitleCard(
        onClick = {},
        title = { Text(stringResource(titleID)) },
        contentColor = MaterialTheme.colors.onSurface
    ) {
        FlowRow {
            for (type in types) {
                if (!typesDrawn.contains(type)) {
                    typesDrawn.add(type)
                    Box {
                        Icon(
                            modifier = Modifier.width(20.dp).height(20.dp),
                            painter = painterResource(id = type.iconResourceID),
                            contentDescription = stringResource(id = type.stringResourceID),
                            tint = type.color
                        )

                        val timesAppeared = typesGrouped[type.name] ?: 1
                        if (timesAppeared > 1) {
                            Text(
                                modifier = Modifier.align(Alignment.BottomEnd),
                                text = "${timesAppeared}x",
                                fontSize = 8.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}