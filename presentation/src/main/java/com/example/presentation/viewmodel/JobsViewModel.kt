package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetVacanciesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class JobsViewModel@Inject constructor(
    private val getVacanciesUseCase: GetVacanciesUseCase
) : ViewModel() {

    private val _offers = MutableStateFlow<List<Offer>>(emptyList())
    val offers: StateFlow<List<Offer>> = _offers

    private val _vacancies = MutableStateFlow<List<Vacancy>>(emptyList())
    val vacancies: StateFlow<List<Vacancy>> = _vacancies

    init {
        fetchJobs()
    }

    private fun fetchJobs() {
        viewModelScope.launch {
            try {
                val response = getVacanciesUseCase()
                _offers.value = response.offers
                _vacancies.value = response.vacancies
            } catch (e: Exception) {
                // Обработка ошибки
            }
        }
    }

    fun toggleFavorite(vacancyId: String) {
        _vacancies.value = _vacancies.value.map { vacancy ->
            if (vacancy.id == vacancyId) vacancy.copy(isFavorite = !vacancy.isFavorite)
            else vacancy
        }
    }

    fun getFavoritesCount(): Int = _vacancies.value.count { it.isFavorite }
}