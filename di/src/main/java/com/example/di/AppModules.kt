package com.example.di

import com.example.data.api.JobsApiService
import com.example.data.network.RetrofitClient
import com.example.data.repository.JobsRepository
import com.example.presentation.viewmodel.VacancyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    // Подключаем RetrofitClient для получения API-сервиса
    single { RetrofitClient.apiService }

    // Репозиторий теперь использует JobsRepository
    single { JobsRepository(get()) }
}

val viewModelModule = module {
    viewModel { VacancyViewModel(get()) }
}