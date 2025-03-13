package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.data.api.ApiService
import com.example.data.database.AppDatabase
import com.example.data.repository.JobsRepositoryImpl
import com.example.domain.repository.JobsRepository
import com.example.domain.usecase.AddVacancyToFavoritesUseCase
import com.example.domain.usecase.GetJobsUseCase
import com.example.presentation.viewmodel.ViewModelFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())  // Позволяет использовать Kotlin data classes с Moshi
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://your.api.baseurl/ ")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "jobs_app_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideJobsRepository(apiService: ApiService, db: AppDatabase): JobsRepository {
        return JobsRepositoryImpl(apiService, db.jobDao())
    }

    @Provides
    @Singleton
    fun provideGetJobsUseCase(repository: JobsRepository): GetJobsUseCase {
        return GetJobsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddVacancyToFavoritesUseCase(repository: JobsRepository): AddVacancyToFavoritesUseCase {
        return AddVacancyToFavoritesUseCase(repository)
    }
}