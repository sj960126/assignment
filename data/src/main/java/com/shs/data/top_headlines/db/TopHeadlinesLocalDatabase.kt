package com.shs.data.top_headlines.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TopHeadlinesEntity::class], version = 1, exportSchema = false)
internal abstract class TopHeadlinesLocalDatabase : RoomDatabase() {

    abstract fun topHeadLinesDao(): TopHeadlinesDao

}