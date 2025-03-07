package com.example.data.api

import com.example.data.model.JobApiResponse
import retrofit2.http.GET

interface JobApiService {

    @GET("api/jobs")
    suspend fun getOffersAndVacancies(): JobApiResponse
}