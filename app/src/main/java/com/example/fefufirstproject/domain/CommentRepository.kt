package com.example.fefufirstproject.domain

import com.example.fefufirstproject.domain.entity.Comment

interface CommentRepository {
    suspend fun addComment(comment: Comment, activityId: Int)
    suspend fun deleteComment(comment: Comment, activityId: Int)
}
