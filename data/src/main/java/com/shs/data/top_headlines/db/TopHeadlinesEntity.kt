package com.shs.data.top_headlines.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topHeadlines")
internal data class TopHeadlinesEntity(
    @PrimaryKey val pk : String,
    val country : String,
    val title : String,
    val detailUrl : String,
    val urlToImage : String,
    val publishedAt : String,
)