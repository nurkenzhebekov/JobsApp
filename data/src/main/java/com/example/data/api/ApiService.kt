package com.example.data.api

import com.example.data.model.JobsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("jobs")
    suspend fun getJobsData(): JobsResponse
}