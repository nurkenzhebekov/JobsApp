package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Vacancy
import com.example.domain.usecase.AddVacancyToFavoritesUseCase
import com.example.domain.usecase.GetJobsUseCase
import kotlinx.coroutines.launch

class JobsViewModel(
    private val getJobsUseCase: GetJobsUseCase,
    private val addVacancyToFavoritesUseCase: AddVacancyToFavoritesUseCase
) : ViewModel() {

    private val _vacancies = MutableLiveData<List<Vacancy>>()
    val vacancies: LiveData<List<Vacancy>> = _vacancies

    fun getJobsData() {
        viewModelScope.launch {
            _vacancies.postValue(getJobsUseCase.execute())
        }
    }

    fun addVacancyToFavorites(vacancy: Vacancy) {
        viewModelScope.launch {
            addVacancyToFavoritesUseCase.execute(vacancy)
        }
    }
}