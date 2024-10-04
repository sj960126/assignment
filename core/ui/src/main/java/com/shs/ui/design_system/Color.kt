package com.shs.ui.design_system

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorPalette(
    val gray90 : Color,
    val gray80 : Color,
    val gray50 : Color,
    val gray40 : Color,
    val gray30 : Color,
    val white : Color,
    val red : Color,
)

val lightColorPalette: ColorPalette = ColorPalette(
    gray90 = Color(0xFF121212),
    gray80 = Color(0xFF212126),
    gray50 = Color(0xFF6B6B72),
    gray40 = Color(0xFF84848B),
    gray30 = Color(0xFF9E9EA3),
    white= Color(0xFFFFFFFF),
    red = Color(0xFFFF0000)
)
