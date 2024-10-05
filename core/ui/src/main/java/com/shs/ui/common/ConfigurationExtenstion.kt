package com.shs.ui.common

import android.content.res.Configuration
import androidx.compose.runtime.Composable

@Composable
fun Configuration.isDeviceWidthOver(with : Int): Boolean = this.screenWidthDp > with
