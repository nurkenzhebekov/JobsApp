package com.example.domain.usecase

import com.example.data.repository.JobsRepository
import javax.inject.Inject

class GetVacanciesUseCase @Inject constructor(
    private val repository: JobsRepository
) {
    suspend operator fun invoke() = repository.getJobsResponse()
}