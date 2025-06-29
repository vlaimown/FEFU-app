package com.example.fefufirstproject.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fefufirstproject.data.local.dao.ActivityDao
import com.example.fefufirstproject.data.local.dto.ActivityCommentCrossRef
import com.example.fefufirstproject.data.local.dto.ActivityDB
import com.example.fefufirstproject.data.local.dto.CommentDB

@Database(
    version = 1,
    entities = [ActivityDB::class, CommentDB::class, ActivityCommentCrossRef::class]
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDao

    companion object {
        private const val DATABASE_NAME = "ActivityDatabase"
        private lateinit var INSTANCE: AppDatabase

        @Synchronized
        operator fun invoke(context: Context): AppDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME,
                )
                    .build()
            }
            return INSTANCE
        }
    }
}