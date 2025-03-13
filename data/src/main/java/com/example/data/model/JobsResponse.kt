package com.example.data.model

data class JobsResponse(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
)

data class Offer(
    val id: String,
    val title: String,
    val link: String,
    val button: Button? = null
)

data class Button(
    val text: String
)

data class Vacancy(
    val id: String,
    val title: String,
    val company: String,
    val address: Address,
    val experience: Experience,
    val salary: Salary,
    val isFavorite: Boolean,
    val appliedNumber: Int,
    val schedules: List<String>,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)

data class Address(
    val town: String,
    val street: String,
    val house: String
)

data class Experience(
    val previewText: String,
    val text: String
)

data class Salary(
    val short: String? = null,
    val full: String
)
