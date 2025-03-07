package com.example.data.repository

import com.example.data.model.Offer
import com.example.data.model.Vacancy

interface JobRepository {

    suspend fun getOffers(): List<Offer>
    suspend fun getVacancies(): List<Vacancy>

}