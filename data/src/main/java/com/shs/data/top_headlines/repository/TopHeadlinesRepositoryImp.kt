package com.shs.data.top_headlines.repository

import android.util.Log
import com.shs.data.network.extension.ApiResult
import com.shs.data.top_headlines.data_source.local.TopHeadLinesLocalDataSource
import com.shs.data.top_headlines.data_source.remote.TopHeadlinesRemoteDataSource
import com.shs.data.top_headlines.mapper.toDomain
import com.shs.domain.top_headlines.model.TopNewsModel
import com.shs.domain.top_headlines.repository.ITopHeadlinesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class TopHeadlinesRepositoryImp @Inject constructor(
    private val remoteDataSource: TopHeadlinesRemoteDataSource,
    private val localDataSource: TopHeadLinesLocalDataSource,
) : ITopHeadlinesRepository{

    override fun fetchTopHeadlinesForCountry(country: String): Flow<List<TopNewsModel>> = flow {

        remoteDataSource.fetchTopHeadlinesForCountry(country = country).collect {
            when(it){
                is ApiResult.Success -> {
                    emit(it.data.toDomain(country = country))
                }
                is ApiResult.Error ->{

                }
            }
        }
    }

}