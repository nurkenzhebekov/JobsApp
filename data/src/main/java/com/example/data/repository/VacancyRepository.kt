package com.example.data.repository

import com.example.data.model.VacancyDto
import com.example.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VacancyRepository(private val apiService: ApiService) {
    fun getVacancies(): Flow<List<VacancyDto>> = flow {
        emit(apiService.getVacancies())
    }
}