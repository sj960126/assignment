package com.shs.ui.design_system

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.shs.core.ui.R

@Immutable
data class TypographySystem(
    val baseTextStyle: TextStyle = TextStyle(
        fontFamily = notosans,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    ),
    val headLine20: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
    ),
    val headLine12: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ),
    val body14: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    val body12: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp
    ),
)


private val notosans = FontFamily(
    Font(R.font.notosans_kr_regular,FontWeight.Normal,FontStyle.Normal),
    Font(R.font.notosans_kr_bold,FontWeight.Bold, FontStyle.Normal),
)
