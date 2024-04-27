package io.schiar.pokechart.view.resulttype.component

import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.ExperimentalWearFoundationApi
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.foundation.rememberActiveFocusRequester
import io.schiar.pokechart.R
import io.schiar.pokechart.view.shared.viewdata.ResultTypeViewData
import kotlinx.coroutines.launch

@OptIn(ExperimentalWearFoundationApi::class)
@Composable
fun ResultTypeView(resultType: ResultTypeViewData) {
    val listState = rememberScalingLazyListState()
    val focusRequester = rememberActiveFocusRequester()
    val coroutineScope = rememberCoroutineScope()

    ScalingLazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .onRotaryScrollEvent {
                coroutineScope.launch { listState.scrollBy(it.verticalScrollPixels) }
                true
            }
            .focusRequester(focusRequester)
            .focusable(),
        autoCentering = AutoCenteringParams(itemIndex = 0),
        horizontalAlignment = Alignment.CenterHorizontally,
        state = listState,
        flingBehavior = ScalingLazyColumnDefaults.snapFlingBehavior(
            state = listState,
            snapOffset = 0.dp
        )
    ) {
        item {
            TypeEffectivenessView(
                typeEffectivenessList = resultType.resistant, titleID = R.string.resistant_to
            )
        }

        item {
            TypeEffectivenessView(
                typeEffectivenessList = resultType.vulnerable, titleID = R.string.vulnerable_to
            )
        }

        if (resultType.types.size != 1) return@ScalingLazyColumn

        item {
            TypeEffectivenessView(
                typeEffectivenessList = resultType.strong, titleID = R.string.strong_against
            )
        }

        item {
            TypeEffectivenessView(
                typeEffectivenessList = resultType.weak, titleID = R.string.weak_against
            )
        }
    }
}