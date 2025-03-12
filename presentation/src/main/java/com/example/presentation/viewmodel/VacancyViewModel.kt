package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Vacancy
import com.example.domain.mapper.toDomain
import com.example.data.repository.VacancyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class VacancyViewModel(private val repository: VacancyRepository) : ViewModel() {
    private val _vacancies = MutableStateFlow<List<Vacancy>>(emptyList())
    val vacancies: StateFlow<List<Vacancy>> = _vacancies

    init {
        fetchVacancies()
    }

    private fun fetchVacancies() {
        viewModelScope.launch {
            repository.getVacancies().collectLatest { vacancyList ->
                _vacancies.value = vacancyList.map { it.toDomain() }
            }
        }
    }
}