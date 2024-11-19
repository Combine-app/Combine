package com.combine.base.ui.arch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun UiEventCollector(
    uiEvent: Flow<CombineUiEvent>,
    block: (CombineUiEvent) -> Unit,
) {
    val lifecycle = LocalLifecycleOwner.current

    LaunchedEffect(uiEvent) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            uiEvent.collect { event ->
                launch {
                    block(event)
                }
            }
        }
    }
}