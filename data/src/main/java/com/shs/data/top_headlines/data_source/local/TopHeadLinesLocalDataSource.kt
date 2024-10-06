package com.shs.data.top_headlines.data_source.local

import com.shs.data.top_headlines.data_source.local.db.TopHeadlinesDao
import javax.inject.Inject

internal class TopHeadLinesLocalDataSource @Inject constructor(
    private val topHeadlinesDao: TopHeadlinesDao
) {

}