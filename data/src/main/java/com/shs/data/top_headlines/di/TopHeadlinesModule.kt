package com.shs.data.top_headlines.di

import com.shs.data.top_headlines.data_source.remote.ITopHeadlinesApi
import com.shs.data.top_headlines.data_source.remote.TopHeadlinesRemoteDataSource
import com.shs.data.top_headlines.repository.TopHeadlinesRepositoryImp
import com.shs.domain.top_headlines.repository.ITopHeadlinesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object TopHeadlinesModule {

    @Provides
    @Singleton
    fun provideTopHeadlinesRepository(
        topHeadLinesRemoteDataSource: TopHeadlinesRemoteDataSource
    ): ITopHeadlinesRepository = TopHeadlinesRepositoryImp(topHeadLinesRemoteDataSource)

    @Provides
    @Singleton
    fun provideTopHeadlinesRemoteDataSource(
        topHeadLinesApi: ITopHeadlinesApi
    ): TopHeadlinesRemoteDataSource = TopHeadlinesRemoteDataSource(topHeadLinesApi)

    @Provides
    @Singleton
    fun provideTopHeadlinesApi(
        retrofit: Retrofit
    ): ITopHeadlinesApi = retrofit.create()

}
