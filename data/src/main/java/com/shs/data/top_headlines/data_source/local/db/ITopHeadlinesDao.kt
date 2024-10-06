package com.shs.data.top_headlines.data_source.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
internal interface ITopHeadlinesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTopHeadlines(topHeadLines: List<TopHeadlinesEntity>)

    @Query("DELETE FROM topHeadlines WHERE country = :country")
    suspend fun clearTopHeadlinesByCountry(country: String)

    @Query("SELECT * FROM topHeadlines WHERE country = :country ORDER BY pk ASC")
    suspend fun fetchTopHeadlinesByCountry(country: String): List<TopHeadlinesEntity>

    @Query("SELECT * FROM topHeadlines WHERE pk = :pk")
    suspend fun fetchTopHeadlinesByPk(pk: String): TopHeadlinesEntity?
}