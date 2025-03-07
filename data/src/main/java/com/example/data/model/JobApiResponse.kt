package com.example.data.model

// Класс для кнопок в предложениях
data class Button(
    val text: String? = null
)

// Класс для предложений
data class Offer(
    val id: String,
    val title: String,
    val link: String,
    val button: Button? = null
)

// Класс для адреса вакансии
data class Address(
    val town: String,
    val street: String,
    val house: String
)

// Класс для описания опыта
data class Experience(
    val previewText: String,
    val text: String
)

// Класс для зарплаты
data class Salary(
    val short: String? = null,
    val full: String
)

// Класс для вакансии
data class Vacancy(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: Address,
    val company: String,
    val experience: Experience,
    val publishedDate: String,
    val isFavorite: Boolean,
    val salary: Salary,
    val schedules: List<String>,
    val appliedNumber: Int,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)

// Класс для полного ответа от API
data class JobApiResponse(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
)
