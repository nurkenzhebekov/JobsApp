package com.example.data.api

import com.example.data.model.JobResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JobsApiService {
    @GET("jobs")
    suspend fun getJobs(
        @Query("query") query: String?,
        @Query("location") location: String?
    ): JobResponse
}