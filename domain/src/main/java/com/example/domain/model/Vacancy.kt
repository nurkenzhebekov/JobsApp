package com.example.domain.model

data class Vacancy(
    val id: String,
    val title: String,
    val company: String,
    val salary: String?,
    val address: String?,
    val experience: String?,
    val publishedDate: String,
    val isFavorite: Boolean,
    val schedules: List<String>,
    val description: String?
)
