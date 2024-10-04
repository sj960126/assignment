package com.shs.data.top_headlines.model

import kotlinx.serialization.Serializable

@Serializable
internal data class TopHeadlinesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>?
){
    data class Article(
        val source: Source?,
        val author: String?,
        val title: String?,
        val description: String?,
        val url: String?,
        val urlToImage: String?,
        val publishedAt: String?,
        val content: String?
    ){
        data class Source(
            val id: String?,
            val name: String?
        )
    }

}

