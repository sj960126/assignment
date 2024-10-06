package com.shs.data.top_headlines.repository

import com.shs.data.network.extension.ApiResult
import com.shs.data.top_headlines.data_source.local.TopHeadLinesLocalDataSource
import com.shs.data.top_headlines.data_source.remote.TopHeadlinesRemoteDataSource
import com.shs.data.top_headlines.mapper.toDomain
import com.shs.data.top_headlines.mapper.topEntity
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
                    with(localDataSource){
                        clearTopHeadlinesByCountry(country = country)
                        saveTopHeadLines(topHeadLines = it.data.topEntity(country = country))
                    }
                    emit(it.data.toDomain(country = country))
                }
                is ApiResult.Error ->{
                    emit(localDataSource.fetchTopHeadlinesByCountry(country = country).toDomain())
                }
            }
        }
    }

    override fun fetchTopHeadlinesByPk(pk: String): Flow<TopNewsModel?> = flow {
        emit(localDataSource.fetchTopHeadlinesByPk(pk)?.toDomain())
    }

}