package com.example.fefufirstproject.presentation.features.activity.state

import androidx.compose.runtime.Immutable
import com.example.fefufirstproject.domain.entity.Activity

@Immutable
data class ActivityState(
    val activities: List<Activity> = listOf(),
    val isLoading: Boolean = false,
    val isError: String = ""
)
