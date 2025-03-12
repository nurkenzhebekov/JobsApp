package com.example.data.repository

import com.example.data.api.JobsApiService
import com.example.data.model.JobResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JobsRepository @Inject constructor(private val apiService: JobsApiService) {

    fun getJobs(query: String?, location: String?): Flow<JobResponse> = flow {
        emit(apiService.getJobs(query, location))
    }
}