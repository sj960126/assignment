package com.shs.data.top_headlines.data_source.remote

import com.shs.data.BuildConfig
import com.shs.data.top_headlines.model.TopHeadlinesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ITopHeadlinesApi {

    @GET(TOP_HEADLINES)
    suspend fun fetchTopHeadlinesForCountry(
        @Query("country") country : String,
        @Query("apiKey") apiKey : String = BuildConfig.API_KEY,
    ) : Response<List<TopHeadlinesResponse>>

    companion object {
        private const val PATH = "top-headlines"
        private const val V2 = "v2/"
        private const val TOP_HEADLINES = "$V2$PATH"
    }
}