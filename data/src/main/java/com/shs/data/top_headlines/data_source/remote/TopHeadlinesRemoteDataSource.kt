package com.shs.data.top_headlines.data_source.remote

import com.shs.data.network.extension.safeFlow
import javax.inject.Inject

internal class TopHeadlinesRemoteDataSource @Inject constructor(
    private val topHeadlinesApi: ITopHeadlinesApi
){
    suspend fun fetchTopHeadlinesForCountry(country : String) = safeFlow {
        topHeadlinesApi.fetchTopHeadlinesForCountry(country = country)
    }
}