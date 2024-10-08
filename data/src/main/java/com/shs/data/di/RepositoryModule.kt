package com.shs.data.di

import com.shs.data.top_headlines.repository.TopHeadlinesRepositoryImp
import com.shs.domain.top_headlines.repository.ITopHeadlinesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindsTopHeadlinesRepository(
        repository : TopHeadlinesRepositoryImp,
    ) : ITopHeadlinesRepository

}