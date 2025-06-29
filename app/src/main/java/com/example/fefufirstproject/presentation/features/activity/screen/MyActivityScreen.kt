package com.example.fefufirstproject.presentation.features.activity.screen

import androidx.compose.runtime.Composable
import com.example.fefufirstproject.presentation.features.activity.state.ActivityState
import com.example.fefufirstproject.presentation.ui.widget.EmptyActivities
import com.example.fefufirstproject.presentation.ui.widget.LazyColumnActivity

@Composable
fun MyActivity(myActivityState: ActivityState, onNavigateToActivityDetail: (id: Int) -> Unit) {
    if (myActivityState.activities.isEmpty()) {
        EmptyActivities()
    } else {
        LazyColumnActivity(activities = myActivityState.activities) { id: Int ->
            onNavigateToActivityDetail(id)
        }
    }
}