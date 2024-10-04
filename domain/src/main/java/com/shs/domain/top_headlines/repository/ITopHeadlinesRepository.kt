package com.shs.domain.top_headlines.repository

import com.shs.domain.top_headlines.model.TopNewsModel
import kotlinx.coroutines.flow.Flow

interface ITopHeadlinesRepository {

    fun fetchTopHeadlinesForCountry(country : String) : Flow<TopNewsModel>

}