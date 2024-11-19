package com.combine.login.presentation

import cafe.adriel.voyager.core.model.screenModelScope
import com.combine.base.ui.arch.BaseScreenModel
import com.combine.base.ui.arch.CombineUiEvent
import kotlinx.coroutines.launch

internal class LoginScreenModel: BaseScreenModel(), LoginScreenContract {

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