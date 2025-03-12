package com.example.data.model

import com.google.gson.annotations.SerializedName

data class JobResponse(
    @SerializedName("vacancies") val vacancies: List<VacancyDto> // Включает список вакансий, который приходит в ответе
)
