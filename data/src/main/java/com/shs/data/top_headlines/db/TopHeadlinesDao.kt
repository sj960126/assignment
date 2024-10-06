package com.shs.data.top_headlines.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
internal interface TopHeadlinesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTopHeadlines(programs: List<TopHeadlinesEntity>)

    @Query("DELETE FROM topHeadlines")
    suspend fun clearTopHeadlines()

}