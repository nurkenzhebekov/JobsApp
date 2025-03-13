package com.example.domain.usecase

import com.example.domain.repository.VacancyRepository
import javax.inject.Inject

class FetchVacanciesUseCase @Inject constructor(
    private val repository: VacancyRepository
) {
    suspend operator fun invoke() = repository.fetchVacancies()
}