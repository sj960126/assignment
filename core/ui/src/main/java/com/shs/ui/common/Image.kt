package com.shs.ui.common

import android.content.Context
import coil.ImageLoader
import coil.request.CachePolicy

fun enableDiskAndMemoryCache(context: Context): ImageLoader =
    ImageLoader.Builder(context)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .build()

