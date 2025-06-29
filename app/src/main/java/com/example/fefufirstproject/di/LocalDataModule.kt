package com.example.fefufirstproject.di

import com.example.fefufirstproject.data.local.dao.ActivityDao
import com.example.fefufirstproject.data.local.source.LocalActivityDataSourceImpl
import com.example.fefufirstproject.data.local.source.LocalCommentDataSourceImpl
import com.example.fefufirstproject.data.repository.activity.LocalActivityDataSource
import com.example.fefufirstproject.data.repository.comment.LocalCommentDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    @Singleton
    fun provideActivityLocalDataSource(activityDao: ActivityDao): LocalActivityDataSource {
        return LocalActivityDataSourceImpl(
            activityDao
        )
    }

    @Provides
    @Singleton
    fun provideCommentLocalDataSource(activityDao: ActivityDao): LocalCommentDataSource {
        return LocalCommentDataSourceImpl(
            activityDao
        )
    }
}