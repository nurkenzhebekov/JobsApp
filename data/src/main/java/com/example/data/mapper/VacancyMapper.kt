package com.example.data.mapper

import com.example.data.model.VacancyDto
import com.example.domain.model.Vacancy


fun VacancyDto.toDomain(): Vacancy {
    return Vacancy(
        id = id,
        title = title,
        company = company,
        salary = salary?.full,
        address = address?.town,
        experience = experience?.previewText,
        publishedDate = publishedDate,
        isFavorite = isFavorite,
        schedules = schedules,
        description = description
    )
}