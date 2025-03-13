package com.example.data.network.models

import com.example.data.network.models.Experience

data class VacancyResponse(
    val id: Int,
    val title: String,
    val company: String,
    val address: Address,
    val experience: Experience,
    val publishedDate: String,
    val lookingNumber: Int?,
    val isFavorite: Boolean
)

data class Address(val town: String)
data class Experience(val previewText: String)
