package com.example.domain.model

data class Vacancy(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: String,
    val company: String,
    val experience: String,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: String,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)
