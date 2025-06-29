package com.example.fefufirstproject.presentation.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.example.fefufirstproject.R
import com.example.fefufirstproject.domain.entity.Activity
import com.example.fefufirstproject.presentation.ui.theme.Typography

@Composable
fun LazyColumnActivity(
    activities: List<Activity>,
    onNavigateToActivityDetail: (id: Int) -> Unit
) {
    val groupedMessages = activities.groupActivitiesByDate()

    LazyColumn(
        Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_small)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        groupedMessages.forEach { (date, activitiesForDate) ->
            item {
                Text(
                    text = date,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    textAlign = TextAlign.Left,
                    style = Typography.labelLarge
                )
            }
            itemsIndexed(activitiesForDate,
                key = { _, activity ->
                    activity.id
                }) { _, activity ->
                ActivityCard(activity = activity) { id: Int ->
                    onNavigateToActivityDetail(id)
                }
            }
        }
    }
}