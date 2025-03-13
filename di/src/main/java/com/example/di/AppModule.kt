package com.example.di

import com.example.data.api.JobsApiService
import com.example.data.repository.JobsRepository
import com.example.domain.usecase.GetVacanciesUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        // URL для скачивания JSON, параметризуется в JobsApiService
        .baseUrl("https://drive.usercontent.google.com/u/0/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideJobsApiService(retrofit: Retrofit): JobsApiService =
        retrofit.create(JobsApiService::class.java)

    @Provides
    @Singleton
    fun provideJobsRepository(apiService: JobsApiService): JobsRepository =
        JobsRepository(apiService)

    @Provides
    @Singleton
    fun provideGetVacanciesUseCase(repository: JobsRepository): GetVacanciesUseCase =
        GetVacanciesUseCase(repository)
}
