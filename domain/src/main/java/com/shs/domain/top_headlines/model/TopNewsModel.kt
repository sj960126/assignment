package com.shs.domain.top_headlines.model

data class TopNewsModel(
    val pk : String,
    val country : String,
    val title : String,
    val detailUrl : String,
    val urlToImage : String,
    val publishedAt : String,
    val isSelected : Boolean = false
)
