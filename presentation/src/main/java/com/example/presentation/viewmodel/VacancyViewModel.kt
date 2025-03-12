package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.JobResponse
import com.example.data.repository.JobsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VacancyViewModel @Inject constructor(
    private val jobsRepository: JobsRepository
) : ViewModel() {

    private val _vacancies = MutableStateFlow<JobResponse?>(null)
    val vacancies: StateFlow<JobResponse?> = _vacancies

    init {
        getVacancies(query = "Android", location = "Bishkek")
    }

    fun getVacancies(query: String?, location: String?) {
        viewModelScope.launch {
            jobsRepository.getJobs(query, location).collect { response ->
                _vacancies.value = response
            }
        }
    }
}