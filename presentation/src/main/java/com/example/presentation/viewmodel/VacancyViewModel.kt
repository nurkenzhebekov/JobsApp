package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.JobResponse
import com.example.data.repository.JobsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VacancyViewModel(private val jobsRepository: JobsRepository) : ViewModel() {

    private val _vacancies = MutableStateFlow<JobResponse?>(null)
    val vacancies: StateFlow<JobResponse?> = _vacancies

    fun getVacancies(query: String?, location: String?) {
        viewModelScope.launch {
            jobsRepository.getJobs(query, location).collect { response ->
                _vacancies.value = response
            }
        }
    }
}