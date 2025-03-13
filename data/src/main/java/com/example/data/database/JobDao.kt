package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface JobDao {
    @Insert
    suspend fun insertVacancy(vacancy: VacancyEntity)

    @Query("SELECT * FROM vacancies")
    suspend fun getAllVacancies(): List<VacancyEntity>
}