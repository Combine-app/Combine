package com.combine.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.combine.base.CombineTheme
import com.combine.base.ui.arch.UiEventCollector
import com.combine.base.ui.backgrounds.Background
import com.combine.base.ui.buttons.CombinePrimaryButton
import com.combine.base.ui.buttons.CombineSecondaryButton
import com.combine.chain.domain.Chain
import com.combine.chain.presentation.components.ChainPicker
import com.combine.home.presentation.HomeScreenModel.UiEvent
import com.combine.navigation.destinations.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

interface HomeScreenContract {
    fun onPrimaryButtonClick()
    fun onSecondaryButtonClick()
}

class HomeScreenImpl : HomeScreen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = koinScreenModel<HomeScreenModel>()

        UiEventCollector(screenModel.uiEvent) { event ->
            when (event) {
                is UiEvent.NavigateToApp -> {}//navigator.push()
            }
        }

        HomeContent(screenModel)
    }
}

@Composable
private fun HomeContent(
    contract: HomeScreenContract,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(brush = Background.blueToPurple)
            .windowInsetsPadding(WindowInsets.safeDrawing),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ChainPicker(chain = Chain.Solana, onClick = {})

        Text(
            text = "You are on home dude",
            color = Color.Black,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.weight(1f))


        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CombinePrimaryButton(
                text = "Create new wallet",
                onClick = contract::onPrimaryButtonClick,
            )
            CombineSecondaryButton(
                text = "Import wallet",
                onClick = contract::onSecondaryButtonClick,
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CombinePrimaryButton(
                text = "Create new wallet",
                onClick = contract::onPrimaryButtonClick,
            )
            CombineSecondaryButton(
                text = "Import wallet",
                onClick = contract::onSecondaryButtonClick,
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CombinePrimaryButton(
                text = "Create new wallet",
                onClick = contract::onPrimaryButtonClick,
            )
            CombineSecondaryButton(
                text = "Import wallet",
                onClick = contract::onSecondaryButtonClick,
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CombinePrimaryButton(
                text = "Create new wallet",
                onClick = contract::onPrimaryButtonClick,
            )
            CombineSecondaryButton(
                text = "Import wallet",
                onClick = contract::onSecondaryButtonClick,
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CombinePrimaryButton(
                text = "Create new wallet",
                onClick = contract::onPrimaryButtonClick,
            )
            CombineSecondaryButton(
                text = "Import wallet",
                onClick = contract::onSecondaryButtonClick,
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CombinePrimaryButton(
                text = "Create new wallet",
                onClick = contract::onPrimaryButtonClick,
            )
            CombineSecondaryButton(
                text = "Import wallet",
                onClick = contract::onSecondaryButtonClick,
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CombinePrimaryButton(
                text = "Create new wallet",
                onClick = contract::onPrimaryButtonClick,
            )
            CombineSecondaryButton(
                text = "Import wallet",
                onClick = contract::onSecondaryButtonClick,
            )
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            CombinePrimaryButton(
                text = "Create new wallet",
                onClick = contract::onPrimaryButtonClick,
            )
            CombineSecondaryButton(
                text = "Import wallet",
                onClick = contract::onSecondaryButtonClick,
            )
        }
    }
}