package com.combine.app

import com.combine.base.ui.arch.BaseScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class AppScreenModel : BaseScreenModel(), AppContract {
    private val _uiState: MutableStateFlow<UiState> =
        MutableStateFlow(UiState(ContentState.Loading))
    val uiState = _uiState.asStateFlow()

    init {
        resolveContentState()
    }

    private fun resolveContentState() {
        val shouldShowLogin = true
        val contentState = if (shouldShowLogin) {
            ContentState.Login
        } else {
            ContentState.App
        }

        _uiState.value = UiState(contentState)
    }

    override fun onContentStateChange(contentState: ContentState) {
        _uiState.update { it.copy(contentState = contentState) }
    }

    enum class ContentState {
        App, Login, Loading,
    }

    data class UiState(
        val contentState: ContentState,
    )
}