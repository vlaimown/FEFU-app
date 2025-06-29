package com.example.fefufirstproject.data.repository.comment

import com.example.fefufirstproject.domain.entity.Comment

interface LocalCommentDataSource {
    suspend fun insertComment(comment: Comment, activityId: Int)
    suspend fun deleteComment(comment: Comment, activityId: Int)
}
