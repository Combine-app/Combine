package com.combine.login.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.combine.base.TekoFontFamily
import com.combine.base.ui.LottieAnimation
import com.combine.base.ui.arch.UiEventCollector
import com.combine.base.ui.backgrounds.Background
import com.combine.base.ui.buttons.CombinePrimaryButton
import com.combine.base.ui.buttons.CombineSecondaryButton
import com.combine.login.Res
import com.combine.navigation.destinations.LoginScreen
import com.combine.login.presentation.LoginScreenModel.UiEvent
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.koinInject

interface LoginScreenContract {
    fun onPrimaryButtonClick()
    fun onSecondaryButtonClick()
}

class LoginScreenImpl: LoginScreen {

    @Composable
    override fun Content() {
        LoginScreen({})
    }
}

@Composable
fun LoginScreen(onNavigateToApp: () -> Unit) {
    val screenModel = koinInject<LoginScreenModel>()
    UiEventCollector(screenModel.uiEvent) { event ->
        when (event) {
            is UiEvent.NavigateToApp -> onNavigateToApp()
        }
    }

    LoginContent(screenModel)
}

@Composable
private fun LoginContent(
    contract: LoginScreenContract,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Background.blueToPurple)
            .windowInsetsPadding(WindowInsets.safeDrawing),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))
        LogoAnimation()
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Access powerful dApps across multiple networks—all in one place.",
            color = Color.Black,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
        )

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

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun LogoAnimation() {
    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes("files/circle-loading.json").decodeToString(),
        )
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "COMBINE",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            letterSpacing = 21.sp,
            fontFamily = TekoFontFamily(),
            color = Color.Black,
        )

        AnimatedVisibility(
            visible = composition != null,
            enter = fadeIn(tween(400))
        ) {
            LottieAnimation(
                composition = composition,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
            )
        }
    }
}