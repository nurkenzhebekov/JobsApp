package com.example.domain.mapper

import com.example.data.model.Vacancy
import com.example.domain.model.Vacancy as DomainVacancy

fun Vacancy.toDomainModel(): DomainVacancy {
    return DomainVacancy(
        id = this.id,
        title = this.title,
        company = this.company,
        address = "${this.address.town}, ${this.address.street}, ${this.address.house}",
        salary = this.salary.full,
        isFavorite = this.isFavorite
    )
}