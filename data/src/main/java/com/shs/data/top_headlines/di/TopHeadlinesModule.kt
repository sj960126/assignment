package com.shs.data.top_headlines.di

import android.content.Context
import androidx.room.Room
import com.shs.data.top_headlines.data_source.local.TopHeadLinesLocalDataSource
import com.shs.data.top_headlines.data_source.local.db.ITopHeadlinesDao
import com.shs.data.top_headlines.data_source.local.db.TopHeadlinesLocalDatabase
import com.shs.data.top_headlines.data_source.remote.ITopHeadlinesApi
import com.shs.data.top_headlines.data_source.remote.TopHeadlinesRemoteDataSource
import com.shs.data.top_headlines.repository.TopHeadlinesRepositoryImp
import com.shs.domain.top_headlines.repository.ITopHeadlinesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object TopHeadlinesModule {

    private const val DATABASE_NAME ="top_headlines_local_database"

    @Provides
    @Singleton
    fun provideTopHeadlinesRepository(
        topHeadLinesRemoteDataSource: TopHeadlinesRemoteDataSource,
        topHeadLinesLocalDataSource: TopHeadLinesLocalDataSource
    ): ITopHeadlinesRepository = TopHeadlinesRepositoryImp(topHeadLinesRemoteDataSource,topHeadLinesLocalDataSource)

    @Provides
    @Singleton
    fun provideTopHeadlinesLocalDataSource(topHeadLIneDao: ITopHeadlinesDao):  TopHeadLinesLocalDataSource  = TopHeadLinesLocalDataSource(topHeadLIneDao)

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

    @Provides
    fun provideTopHeadlinesDao(database: TopHeadlinesLocalDatabase): ITopHeadlinesDao = database.topHeadLinesDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): TopHeadlinesLocalDatabase = Room.databaseBuilder(appContext, TopHeadlinesLocalDatabase::class.java, DATABASE_NAME).build()

}
