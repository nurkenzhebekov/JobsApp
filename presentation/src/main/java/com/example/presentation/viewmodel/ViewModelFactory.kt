package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.AddVacancyToFavoritesUseCase
import com.example.domain.usecase.GetJobsUseCase

class ViewModelFactory(
    private val getJobsUseCase: GetJobsUseCase,
    private val addVacancyToFavoritesUseCase: AddVacancyToFavoritesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return JobsViewModel(getJobsUseCase, addVacancyToFavoritesUseCase) as T
    }
}