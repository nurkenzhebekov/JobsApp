package com.example.data.di

import com.example.data.api.JobApiService
import com.example.data.repository.JobRepository
import com.example.data.repository.JobRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://drive.usercontent.google.com/u/0/uc?id=1z4TbeDkbfXkvgpoJprXbN85uCcD7f00r&export=download"

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideJobApiService(retrofit: Retrofit): JobApiService {
        return retrofit.create(JobApiService::class.java)
    }

    @Provides
    fun provideJobRepository(jobApiService: JobApiService): JobRepository {
        return JobRepositoryImpl(jobApiService)
    }
}