package com.shs.domain.top_headlines.model

data class TopNewsModel(
    val title : String,
    val urlToImage : String,
    val publishedAt : String,
    val isSelected : Boolean = false
)
