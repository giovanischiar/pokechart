package io.schiar.pokechart.view.types.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonBorder
import androidx.wear.compose.material.ButtonColors
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import io.schiar.pokechart.viewmodel.iconButtonIconPadding
import io.schiar.pokechart.viewmodel.iconButtonPadding
import io.schiar.pokechart.viewmodel.iconButtonSize

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    border: ButtonBorder = ButtonDefaults.buttonBorder(),
    iconResourceID: Int,
    contentDescriptionStringResourceID: Int,
    iconTint: Color,
    onPress: () -> Unit
) {
    Button(
        modifier = modifier.padding(all = iconButtonPadding.dp).size(iconButtonSize.dp),
        onClick = onPress,
        border = border,
        colors = colors
    ) {
        Icon(
            modifier = Modifier.padding(all = iconButtonIconPadding.dp),
            painter = painterResource(id = iconResourceID),
            contentDescription = stringResource(id = contentDescriptionStringResourceID),
            tint = iconTint
        )
    }
}