package com.example.domain.repository

interface JobRepository {

    suspend fun getOffers(): List<Offer>
    suspend fun getVacancies(): List<Vacancy>
}