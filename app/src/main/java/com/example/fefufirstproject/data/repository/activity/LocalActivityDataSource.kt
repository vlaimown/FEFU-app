package com.example.fefufirstproject.data.repository.activity

import com.example.fefufirstproject.domain.entity.Activity
import kotlinx.coroutines.flow.Flow

interface LocalActivityDataSource {
    suspend fun insertActivity(activity: Activity)
    suspend fun deleteActivity(activity: Activity)
    fun getActivity(idActivity: Int): Flow<Activity>
    fun getActivities(myActivities: Boolean): Flow<List<Activity>>
}