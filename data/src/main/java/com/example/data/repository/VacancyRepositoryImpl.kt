package com.example.data.repository

import com.example.data.database.VacancyDao
import com.example.data.database.VacancyEntity
import com.example.data.network.ApiService
import com.example.domain.repository.VacancyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VacancyRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val vacancyDao: VacancyDao
) : VacancyRepository {
    override fun getVacancies(): Flow<List<VacancyEntity>> = vacancyDao.getAllVacancies()

    override suspend fun fetchVacancies() {
        val response = apiService.getVacancies()
        val mappedVacancies = response.map {
            VacancyEntity(
                id = it.id,
                title = it.title,
                company = it.company,
                town = it.address.town,
                experience = it.experience.previewText,
                publishedDate = it.publishedDate,
                lookingNumber = it.lookingNumber,
                isFavorite = it.isFavorite
            )
        }
        mappedVacancies.forEach { vacancyDao.insertVacancy(it) }
    }

    override suspend fun toggleFavorite(vacancy: VacancyEntity) {
        if (vacancy.isFavorite) {
            vacancyDao.deleteVacancy(vacancy.id)
        } else {
            vacancyDao.insertVacancy(vacancy.copy(isFavorite = true))
        }
    }
}