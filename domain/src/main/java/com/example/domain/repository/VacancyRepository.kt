package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface VacancyRepository {
    fun getVacancies(): Flow<List<VacancyEntity>>
    suspend fun fetchVacancies()
    suspend fun toggleFavorite(vacancy: VacancyEntity)
}