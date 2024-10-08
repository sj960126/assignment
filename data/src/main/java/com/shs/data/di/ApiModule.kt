package com.shs.data.di

import com.shs.data.top_headlines.data_source.remote.ITopHeadlinesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object ApiModule {

    @Provides
    @Singleton
    fun provideTopHeadlinesApi(
        retrofit: Retrofit
    ): ITopHeadlinesApi = retrofit.create()

}