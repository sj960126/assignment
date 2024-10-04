package com.shs.data.top_headlines.mapper

import com.shs.data.top_headlines.model.TopHeadlinesResponse
import com.shs.domain.top_headlines.model.TopNewsModel

internal fun TopHeadlinesResponse.toDomain(country: String): List<TopNewsModel> =
    this.articles?.mapIndexed { index, article ->
        TopNewsModel(
            pk = index,
            country = country,
            title = article.title.orEmpty(),
            detailUrl = article.url.orEmpty(),
            urlToImage = article.urlToImage.orEmpty(),
            publishedAt = article.publishedAt.orEmpty()
        )
    } ?: emptyList()