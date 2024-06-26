package io.schiar.pokechart.view.resulttype.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
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
import io.schiar.pokechart.view.shared.util.color
import io.schiar.pokechart.view.shared.util.iconResourceID
import io.schiar.pokechart.view.shared.util.stringResourceID
import io.schiar.pokechart.view.shared.viewdata.TypeEffectivenessViewData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TypeEffectivenessView(typeEffectivenessList: List<TypeEffectivenessViewData>, titleID: Int) {
    TitleCard(
        onClick = {},
        title = { Text(stringResource(titleID)) },
        contentColor = MaterialTheme.colors.onSurface
    ) {
        FlowRow {
            for ((type, multiplier) in typeEffectivenessList) {
                Box {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = type.iconResourceID),
                        contentDescription = stringResource(id = type.stringResourceID),
                        tint = type.color
                    )

                    if (multiplier != "1") {
                        Text(
                            modifier = Modifier.align(Alignment.BottomEnd),
                            text = "${multiplier}x",
                            fontSize = 8.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}