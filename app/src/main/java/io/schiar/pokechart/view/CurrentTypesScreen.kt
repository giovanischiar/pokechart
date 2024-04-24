package io.schiar.pokechart.view

import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.ExperimentalWearFoundationApi
import androidx.wear.compose.foundation.lazy.AutoCenteringParams
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.foundation.rememberActiveFocusRequester
import androidx.wear.compose.material.Icon
import io.schiar.pokechart.R
import io.schiar.pokechart.view.components.TypeDetail
import io.schiar.pokechart.viewmodel.CurrentTypesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalWearFoundationApi::class)
@Composable
fun CurrentTypesScreen(currentTypesViewModel: CurrentTypesViewModel) {
    val currentTypes = currentTypesViewModel.currentTypesFlow.collectAsState(emptyList())

    if (currentTypes.value.isNotEmpty()) {
        val listState = rememberScalingLazyListState()
        val focusRequester = rememberActiveFocusRequester()
        val coroutineScope = rememberCoroutineScope()
        val currentType = currentTypes.value[0]
        Column {
            Column(modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(5.dp))
                Icon(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(currentType.iconCode()),
                    contentDescription = currentType.name,
                    tint = currentType.color()
                )
                Spacer(modifier = Modifier.height(5.dp))
            }

            ScalingLazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .onRotaryScrollEvent {
                        coroutineScope.launch {
                            listState.scrollBy(it.verticalScrollPixels)
                        }
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
                    TypeDetail(types = currentType.strong, titleID = R.string.strong_against)
                }

                item {
                    TypeDetail(types = currentType.weak, titleID = R.string.weak_against)
                }

                item {
                    TypeDetail(types = currentType.resistant, titleID = R.string.resistant_to)
                }

                item {
                    TypeDetail(types = currentType.vulnerable, titleID = R.string.vulnerable_to)
                }
            }
        }
    }
}