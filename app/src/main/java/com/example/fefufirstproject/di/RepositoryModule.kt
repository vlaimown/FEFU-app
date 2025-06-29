package com.example.fefufirstproject.di

import com.example.fefufirstproject.data.repository.activity.LocalActivityDataSource
import com.example.fefufirstproject.data.repository.activity.MockActivityRepository
import com.example.fefufirstproject.data.repository.comment.CommentRepositoryImpl
import com.example.fefufirstproject.data.repository.comment.LocalCommentDataSource
import com.example.fefufirstproject.domain.ActivityRepository
import com.example.fefufirstproject.domain.CommentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideActivityRepository(
        localActivityDataSource: LocalActivityDataSource
    ): ActivityRepository {
        return MockActivityRepository(localActivityDataSource)
    }

    @Provides
    @Singleton
    fun provideCommentRepository(
        localCommentDataSource: LocalCommentDataSource
    ): CommentRepository {
        return CommentRepositoryImpl(localCommentDataSource)
    }
}