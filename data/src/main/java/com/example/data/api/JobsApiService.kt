package com.example.data.api

import com.example.data.model.JobsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JobsApiService {
    @GET("uc")
    suspend fun getJobs(
        @Query("id") id: String = "1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r",
        @Query("export") export: String = "download"
    ): JobsResponse
}