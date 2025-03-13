package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetVacanciesUseCase
import com.example.domain.usecase.ToggleFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobViewModel @Inject constructor(
    private val getVacanciesUseCase: GetVacanciesUseCase,
    private val fetchVacanciesUseCase: FetchVacanciesUseCase,
    private val toggleFavoriteUseCase: ToggleFavoriteUseCase
) : ViewModel() {
    val vacancies = getVacanciesUseCase().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        viewModelScope.launch { fetchVacanciesUseCase() }
    }

    fun toggleFavorite(vacancy: VacancyEntity) {
        viewModelScope.launch { toggleFavoriteUseCase(vacancy) }
    }
}