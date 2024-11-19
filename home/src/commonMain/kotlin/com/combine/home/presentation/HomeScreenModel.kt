package com.combine.home.presentation

import cafe.adriel.voyager.core.model.screenModelScope
import com.combine.base.ui.arch.BaseScreenModel
import com.combine.base.ui.arch.CombineUiEvent
import kotlinx.coroutines.launch

internal class HomeScreenModel: BaseScreenModel(), HomeScreenContract {

    override fun onPrimaryButtonClick() {
        screenModelScope.launch {
            _uiEvent.emit(UiEvent.NavigateToApp)
        }
    }

    override fun onSecondaryButtonClick() {
        screenModelScope.launch {
            _uiEvent.emit(UiEvent.NavigateToApp)
        }
    }

    sealed interface UiEvent: CombineUiEvent {
        data object NavigateToApp: UiEvent
    }
}