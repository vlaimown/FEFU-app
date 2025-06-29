package com.example.fefufirstproject.presentation.features.activity.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.fefufirstproject.domain.entity.Activity
import com.example.fefufirstproject.domain.entity.Comment
import com.example.fefufirstproject.presentation.ui.widget.ScaffoldWithOptionalAppBar
import java.util.UUID

import com.example.fefufirstproject.R
import com.example.fefufirstproject.presentation.ui.theme.Typography
import com.example.fefufirstproject.presentation.ui.theme.mainColor
import com.example.fefufirstproject.presentation.ui.widget.CommentInputField
import com.example.fefufirstproject.presentation.ui.widget.CommentList

@Composable
fun DetailActivityScreen(
    activityState: Activity,
    onAddComment: (Comment) -> Unit,
    onNavigateBack: () -> Unit
) {
    var newComment by remember { mutableStateOf("") }

    ScaffoldWithOptionalAppBar(
        showAppBar = true,
        title = activityState.title,
        onClickBackButton = onNavigateBack,
        actions = {
            if (activityState.myActivities) {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Default.Delete,
                        contentDescription = null,
                        tint = mainColor
                    )
                }

                IconButton(onClick = { }) {
                    Icon(
                        Icons.Default.Share,
                        contentDescription = null,
                        tint = mainColor
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                ActivityHeader(activityState = activityState)

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_medium)))

                CommentInputField(
                    value = newComment,
                    onValueChange = { newComment = it },
                    onSubmit = {
                        if (newComment.isNotBlank()) {
                            val commentView =
                                Comment(
                                    id = UUID.randomUUID().hashCode(),
                                    content = newComment
                                )
                            onAddComment(commentView)
                            newComment = ""
                        }
                    }
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_xsmall)))

                CommentList(comments = activityState.comments)
            }
        }
    )
}

@Composable
fun ActivityHeader(
    activityState: Activity,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        if (!activityState.myActivities) {
            Text(text = activityState.accountName, style = Typography.titleSmall)
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_xsmall)))
        Column {
            Text(
                text = activityState.formattedDistance,
                style = Typography.displayLarge
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_xsmall)))

            Text(
                text = activityState.formattedCreatedAt,
                style = Typography.bodySmall
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_medium)))

            Text(
                text = activityState.formattedDuration,
                style = Typography.displayLarge
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_xsmall)))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.spacer_xsmall))
        ) {
            Text(
                text = stringResource(R.string.detail_activity_start_text),
                style = Typography.bodySmall
            )
            Text(
                text = activityState.formattedStartTime,
                style = Typography.bodySmall
            )

            Text(
                text = stringResource(R.string.time_text_separator),
                style = Typography.bodySmall
            )

            Text(
                text = stringResource(R.string.detail_activity_end_text),
                style = Typography.bodySmall
            )
            Text(
                text = activityState.formattedEndTime,
                style = Typography.bodySmall
            )
        }
    }
}