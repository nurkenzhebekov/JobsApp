package com.example.data.network

import com.example.data.model.JobResponse
import retrofit2.http.GET

interface ApiService {
    @GET("vacancies")
    suspend fun getVacancies(): JobResponse
}