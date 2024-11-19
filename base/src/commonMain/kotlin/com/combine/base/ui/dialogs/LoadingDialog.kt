package com.combine.base.ui.dialogs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.combine.base.ui.LottieAnimation
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import com.combine.base.Res
import com.combine.base.ui.backgrounds.Background
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoadingDialog() {
    Box(
        modifier = Modifier
            .background(Background.blueToPurple)
            .fillMaxSize(),
    ) {
        AnimatedVisibility(
            visible = true,
            enter = slideInVertically(),
            exit = slideOutVertically(),
        ) {
            Dialog(
                onDismissRequest = {},
                content = {
                    val composition by rememberLottieComposition {
                        LottieCompositionSpec.JsonString(
                            Res.readBytes("files/loading-dialog.json").decodeToString(),
                        )
                    }

                    LottieAnimation(composition = composition)
                },
            )
        }
    }
}