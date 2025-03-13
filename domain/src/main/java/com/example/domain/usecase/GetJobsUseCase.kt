package com.example.domain.usecase

import com.example.domain.model.Vacancy
import com.example.domain.repository.JobsRepository

class GetJobsUseCase(private val repository: JobsRepository) {
    suspend fun execute(): List<Vacancy> {
        return repository.getJobsData()
    }
}