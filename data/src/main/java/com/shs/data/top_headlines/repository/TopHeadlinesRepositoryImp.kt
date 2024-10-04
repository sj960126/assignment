package com.shs.data.top_headlines.repository

import com.shs.data.top_headlines.data_source.remote.TopHeadlinesRemoteDataSource
import com.shs.domain.top_headlines.model.TopNewsModel
import com.shs.domain.top_headlines.repository.ITopHeadlinesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TopHeadlinesRepositoryImp @Inject constructor(
    private val remoteDataSource: TopHeadlinesRemoteDataSource
) : ITopHeadlinesRepository{

    override fun fetchTopHeadlinesForCountry(country: String): Flow<TopNewsModel> {
        TODO("Not yet implemented")
    }

}