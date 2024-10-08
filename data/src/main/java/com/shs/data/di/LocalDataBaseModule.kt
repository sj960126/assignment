package com.shs.data.di

import android.content.Context
import androidx.room.Room
import com.shs.data.top_headlines.data_source.local.db.ITopHeadlinesDao
import com.shs.data.top_headlines.data_source.local.db.TopHeadlinesLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object LocalDataBaseModule {

    private const val TOP_HEADLINES_DATABASE_NAME = "top_headlines_local_database"

    @Provides
    @Singleton
    fun provideTopHeadlinesDao(database: TopHeadlinesLocalDatabase): ITopHeadlinesDao = database.topHeadLinesDao()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): TopHeadlinesLocalDatabase =
        Room.databaseBuilder(
            appContext, TopHeadlinesLocalDatabase::class.java,
            TOP_HEADLINES_DATABASE_NAME
        ).build()

}