package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.database.JobDao
import com.example.data.database.VacancyEntity
import com.example.domain.model.Vacancy
import com.example.domain.repository.JobsRepository

class JobsRepositoryImpl(
    private val apiService: ApiService,
    private val jobDao: JobDao
) : JobsRepository {
    override suspend fun getJobsData(): List<Vacancy> {
        val response = apiService.getJobsData()
        return response.vacancies.map { vacancy ->
            Vacancy(
                id = vacancy.id,
                title = vacancy.title,
                company = vacancy.company,
                address = "${vacancy.address.town}, ${vacancy.address.street}, ${vacancy.address.house}",
                salary = vacancy.salary.full,
                isFavorite = vacancy.isFavorite
            )
        }
    }

    override suspend fun addVacancyToFavorites(vacancy: Vacancy) {
        jobDao.insertVacancy(
            VacancyEntity(
                id = vacancy.id,
                title = vacancy.title,
                company = vacancy.company,
                address = vacancy.address,
                isFavorite = vacancy.isFavorite
            )
        )
    }

    override suspend fun getFavoriteVacancies(): List<Vacancy> {
        return jobDao.getAllVacancies().map { entity ->
            Vacancy(
                id = entity.id,
                title = entity.title,
                company = entity.company,
                address = entity.address,
                salary = "",  // Need to adjust logic for salary in favorites
                isFavorite = entity.isFavorite
            )
        }
    }
}