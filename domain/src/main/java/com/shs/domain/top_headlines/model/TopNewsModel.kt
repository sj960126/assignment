package com.shs.domain.top_headlines.model

data class TopNewsModel(
    val pk : Int,
    val country : String,
    val title : String,
    val detailUrl : String,
    val urlToImage : String,
    val publishedAt : String,
    val isSelected : Boolean = false
)
