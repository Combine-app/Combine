package com.combine.base.ui.backgrounds

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.combine.base.Colors

object Background {
    val blueToPurple = Brush.verticalGradient(
        colors = listOf(Colors.pastelBlue, Color.White)
    )
}