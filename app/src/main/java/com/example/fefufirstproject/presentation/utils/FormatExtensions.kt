package com.example.fefufirstproject.presentation.utils

import com.example.fefufirstproject.domain.entity.Activity
import java.time.LocalDateTime

fun List<Activity>.groupActivitiesByDate(): List<Pair<String, List<Activity>>> {
    return this
        .groupBy { activity ->
            activity.formattedCreatedDate
        }
        .toList()
}


