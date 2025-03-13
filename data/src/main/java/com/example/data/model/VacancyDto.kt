package com.example.data.model

import com.google.gson.annotations.SerializedName

data class VacancyDto(
    val id: String,
    val title: String,
    val company: String,
    val salary: SalaryDto?,
    val address: AddressDto?,
    val experience: ExperienceDto?,
    val publishedDate: String,
    val isFavorite: Boolean,
    val schedules: List<String>,
    val description: String?
)

data class SalaryDto(val full: String?)
data class AddressDto(val town: String)
data class ExperienceDto(val previewText: String)