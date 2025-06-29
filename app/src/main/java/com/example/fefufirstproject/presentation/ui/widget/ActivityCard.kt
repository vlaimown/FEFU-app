package com.example.fefufirstproject.presentation.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.fefufirstproject.R
import com.example.fefufirstproject.presentation.ui.theme.Typography

@Composable
fun ActivityCard(activity: Activity, onNavigateToActivityDetail: (id: Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_small),
                horizontal = dimensionResource(id = R.dimen.padding_xsmall)
            )
            .clickable {
                onNavigateToActivityDetail(activity.id)
            },
        elevation = 4.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.padding_medium),
                    horizontal = dimensionResource(id = R.dimen.padding_xsmall)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_xsmall)),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = activity.formattedDistance,
                    style = Typography.displayLarge
                )

                Text(text = activity.accountName, style = Typography.titleSmall, textAlign = TextAlign.End)
            }

            Row(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall))
            ) {
                Text(
                    text = activity.formattedDuration,
                    style = Typography.bodyLarge
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_small),
                        start = dimensionResource(id = R.dimen.padding_xsmall)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = activity.title,
                    style = Typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}