package com.example.domain.usecase

import com.example.domain.repository.VacancyRepository
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val repository: VacancyRepository
) {
    suspend operator fun invoke(vacancy: VacancyEntity) = repository.toggleFavorite(vacancy)
}