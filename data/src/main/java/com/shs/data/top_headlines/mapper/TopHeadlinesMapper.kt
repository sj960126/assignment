package com.shs.data.top_headlines.mapper

import com.shs.data.top_headlines.data_source.local.db.TopHeadlinesEntity
import com.shs.data.top_headlines.model.TopHeadlinesResponse
import com.shs.domain.top_headlines.model.TopNewsModel

internal fun TopHeadlinesResponse.toDomain(country: String): List<TopNewsModel> =
    this.articles?.mapIndexed { index, article ->
        TopNewsModel(
            pk = country+index,
            country = country,
            title = article.title.orEmpty(),
            detailUrl = article.url.orEmpty(),
            urlToImage = article.urlToImage.orEmpty(),
            publishedAt = article.publishedAt.orEmpty(),
        )
    } ?: emptyList()


internal fun TopHeadlinesResponse.topEntity(country: String): List<TopHeadlinesEntity> =
    this.articles?.mapIndexed { index, article ->
        TopHeadlinesEntity(
            pk = country+index,
            country = country,
            title = article.title.orEmpty(),
            detailUrl = article.url.orEmpty(),
            urlToImage = article.urlToImage.orEmpty(),
            publishedAt = article.publishedAt.orEmpty(),
        )
    } ?: emptyList()

internal fun List<TopHeadlinesEntity>.toDomain(): List<TopNewsModel> =
    this.map { topHeadlinesEntity ->
        TopNewsModel(
            pk = topHeadlinesEntity.pk,
            country = topHeadlinesEntity.country,
            title = topHeadlinesEntity.title,
            detailUrl = topHeadlinesEntity.detailUrl,
            urlToImage = topHeadlinesEntity.urlToImage,
            publishedAt = topHeadlinesEntity.publishedAt,
        )
    } ?: emptyList()

