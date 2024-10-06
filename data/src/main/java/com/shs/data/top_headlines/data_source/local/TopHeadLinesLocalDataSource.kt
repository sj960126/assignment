package com.shs.data.top_headlines.data_source.local

import com.shs.data.top_headlines.data_source.local.db.ITopHeadlinesDao
import com.shs.data.top_headlines.data_source.local.db.TopHeadlinesEntity
import javax.inject.Inject

internal class TopHeadLinesLocalDataSource @Inject constructor(
    private val topHeadlinesDao: ITopHeadlinesDao
) {

    suspend fun saveTopHeadLines(topHeadLines : List<TopHeadlinesEntity>) = topHeadlinesDao.saveTopHeadlines(topHeadLines = topHeadLines)

    suspend fun clearTopHeadlinesByCountry(country: String) = topHeadlinesDao.clearTopHeadlinesByCountry(country)

    suspend fun fetchTopHeadlinesByCountry(country: String): List<TopHeadlinesEntity> = topHeadlinesDao.fetchTopHeadlinesByCountry(country)

    suspend fun fetchTopHeadlinesByPk(pk: String): TopHeadlinesEntity? = topHeadlinesDao.fetchTopHeadlinesByPk(pk)

}
