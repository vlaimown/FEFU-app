package com.example.fefufirstproject.data.local.source

import com.example.fefufirstproject.data.local.dao.ActivityDao
import com.example.fefufirstproject.data.local.dto.ActivityCommentCrossRef
import com.example.fefufirstproject.data.local.dto.CommentDB
import com.example.fefufirstproject.data.local.dto.mapper.CommentMapper
import com.example.fefufirstproject.data.repository.comment.LocalCommentDataSource
import com.example.fefufirstproject.domain.entity.Comment
import javax.inject.Inject

class LocalCommentDataSourceImpl @Inject constructor(
    private val activityDao: ActivityDao,
    private val commentMapper: CommentMapper = CommentMapper
) : LocalCommentDataSource {
    override suspend fun insertComment(comment: Comment, activityId: Int) {
        val commentDb: CommentDB = commentMapper.map(comment)

        activityDao.insertComment(commentDb)
        activityDao.insertActivityCommentCrossRef(
            ActivityCommentCrossRef(
                activityId = activityId,
                commentId = commentDb.id,
            ),
        )
    }

    override suspend fun deleteComment(comment: Comment, activityId: Int) {
        val commentDB: CommentDB = commentMapper.map(comment)

        activityDao.insertComment(commentDB)
        activityDao.deleteActivityCommentCrossRef(
            ActivityCommentCrossRef(
                activityId = activityId,
                commentId = commentDB.id,
            ),
        )
    }
}