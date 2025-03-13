package com.example.domain.model

data class Vacancy(
    val id: String,
    val title: String,
    val company: String,
    val address: String,
    val salary: String,
    val isFavorite: Boolean
)
