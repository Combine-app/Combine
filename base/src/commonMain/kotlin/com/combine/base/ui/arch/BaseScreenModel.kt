package com.combine.base.ui.arch

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseScreenModel: ScreenModel {
    protected val _uiEvent: MutableSharedFlow<CombineUiEvent> = MutableSharedFlow()
    val uiEvent = _uiEvent.asSharedFlow()
}