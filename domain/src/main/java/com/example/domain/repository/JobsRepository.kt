package com.example.domain.repository

import com.example.domain.model.Vacancy

interface JobsRepository {
    suspend fun getJobsData(): List<Vacancy>
    suspend fun addVacancyToFavorites(vacancy: Vacancy)
    suspend fun getFavoriteVacancies(): List<Vacancy>
}