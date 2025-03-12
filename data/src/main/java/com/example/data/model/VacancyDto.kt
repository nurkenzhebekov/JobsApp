package com.example.data.model

import com.google.gson.annotations.SerializedName

data class VacancyDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("company") val company: String,
    @SerializedName("salary") val salary: SalaryDto?,
    @SerializedName("address") val address: AddressDto?,
    @SerializedName("experience") val experience: ExperienceDto?,
    @SerializedName("publishedDate") val publishedDate: String,
    @SerializedName("isFavorite") val isFavorite: Boolean,
    @SerializedName("schedules") val schedules: List<String>,
    @SerializedName("description") val description: String?
)

data class SalaryDto(@SerializedName("full") val full: String?)
data class AddressDto(@SerializedName("town") val town: String)
data class ExperienceDto(@SerializedName("previewText") val previewText: String)