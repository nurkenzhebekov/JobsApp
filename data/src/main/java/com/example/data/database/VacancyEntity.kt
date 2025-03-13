package com.example.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacancies")
data class VacancyEntity(
    @PrimaryKey val id: String,
    val title: String,
    val company: String,
    val address: String,
    val isFavorite: Boolean
)
