package com.example.domain.usecase

import com.example.domain.model.Vacancy
import com.example.domain.repository.JobsRepository

class AddVacancyToFavoritesUseCase(private val repository: JobsRepository) {
    suspend fun execute(vacancy: Vacancy) {
        repository.addVacancyToFavorites(vacancy)
    }
}