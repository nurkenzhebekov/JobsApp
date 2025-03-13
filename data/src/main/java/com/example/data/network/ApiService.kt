package com.example.data.network

import com.example.data.network.models.VacancyResponse
import retrofit2.http.GET

interface ApiService {
    @GET("vacancies")
    suspend fun getVacancies(): List<VacancyResponse>
}