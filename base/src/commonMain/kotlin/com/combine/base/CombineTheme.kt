package com.combine.base

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font

@Composable
fun CombineTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = Typography(defaultFontFamily = getFontFamily())
    ) {
        content()
    }
}

@Composable
private fun getFontFamily() = FontFamily(
    Font(Res.font.Montserrat_Light, weight = FontWeight.Light),
    Font(Res.font.Montserrat_Bold, weight = FontWeight.Bold),
    Font(Res.font.Montserrat_Medium, weight = FontWeight.Medium),
    Font(Res.font.Montserrat_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.Montserrat_Regular, weight = FontWeight.Normal),
)

@Composable
fun TekoCombineTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = Typography(defaultFontFamily = TekoFontFamily())
    ) {
        content()
    }
}

@Composable
fun TekoFontFamily() = FontFamily(
    Font(Res.font.Teko_Light, weight = FontWeight.Light),
    Font(Res.font.Teko_Bold, weight = FontWeight.Bold),
    Font(Res.font.Teko_Medium, weight = FontWeight.Medium),
    Font(Res.font.Teko_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.Teko_Regular, weight = FontWeight.Normal),
)