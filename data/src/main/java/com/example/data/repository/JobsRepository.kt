package com.example.data.repository

import com.example.data.api.JobsApiService
import com.example.data.model.JobsResponse
import javax.inject.Inject

class JobsRepository @Inject constructor(
    private val apiService: JobsApiService
) {
    suspend fun getJobsResponse(): JobsResponse = apiService.getJobs()
}