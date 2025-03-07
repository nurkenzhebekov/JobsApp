package com.example.domain.usecase

import com.example.domain.model.Vacancy
import com.example.domain.repository.JobRepository

class GetVacanciesUseCase(private val jobRepository: JobRepository) {

    suspend operator fun invoke(): List<Vacancy> {
        return jobRepository.getVacancies()
    }
}