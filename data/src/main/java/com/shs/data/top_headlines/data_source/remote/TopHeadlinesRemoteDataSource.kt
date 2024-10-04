package com.shs.data.top_headlines.data_source.remote

import javax.inject.Inject

internal class TopHeadlinesRemoteDataSource @Inject constructor(
    private val topHeadlinesApi: ITopHeadlinesApi
){
    suspend fun fetchTopHeadlinesForCountry(country : String) = topHeadlinesApi.fetchTopHeadlinesForCountry(country = country)
}