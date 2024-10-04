package com.shs.ui.design_system

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf


val LocalColorPalette = compositionLocalOf<ColorPalette> {
    error("Error ColorPalette provided")
}

val LocalTypographySystem = compositionLocalOf<TypographySystem> {
    error("Error TypographySystem provided")
}

@Composable
fun MainTheme(
    colorPalette: ColorPalette = lightColorPalette,
    typography: TypographySystem = TypographySystem(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorPalette provides colorPalette,
        LocalTypographySystem provides typography,
        content = content
    )
}