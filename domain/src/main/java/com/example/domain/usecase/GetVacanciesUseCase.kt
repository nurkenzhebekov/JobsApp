package com.example.domain.usecase

import com.example.data.database.VacancyEntity
import com.example.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVacanciesUseCase @Inject constructor(
    private val repository: VacancyRepository
) {
    operator fun invoke(): Flow<List<VacancyEntity>> = repository.getVacancies()
}