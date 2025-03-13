package com.example.domain.usecase

import com.example.domain.repository.JobRepository

class GetOffersUseCase(private val jobRepository: JobRepository) {

    suspend operator fun invoke(): List<Offer> {
        return jobRepository.getOffers()
    }
}
