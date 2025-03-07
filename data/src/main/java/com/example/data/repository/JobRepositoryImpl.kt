package com.example.data.repository

import android.util.Log
import com.example.data.api.JobApiService
import com.example.data.model.Offer
import com.example.data.model.Vacancy

class JobRepositoryImpl(private val jobApiService: JobApiService) : JobRepository {

    override suspend fun getOffers(): List<Offer> {
        return try {
            jobApiService.getOffersAndVacancies().offers
        } catch (e: Exception) {
            // Обработка ошибки
            Log.e("JobRepository", "Error fetching offers", e)
            emptyList()
        }
    }

    override suspend fun getVacancies(): List<Vacancy> {
        return try {
            jobApiService.getOffersAndVacancies().vacancies
        } catch (e: Exception) {
            // Обработка ошибки
            Log.e("JobRepository", "Error fetching offers", e)
            emptyList()
        }
    }

}