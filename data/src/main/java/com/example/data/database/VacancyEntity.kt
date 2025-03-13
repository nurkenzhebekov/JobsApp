package com.example.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacancies")
data class VacancyEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val company: String,
    val town: String,
    val experience: String,
    val publishedDate: String,
    val lookingNumber: Int?,
    val isFavorite: Boolean
)
