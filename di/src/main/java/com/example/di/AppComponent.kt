package com.example.di

import android.app.Application
import com.example.jobsapp.MainActivity
import com.example.presentation.ui.FavoritesFragment
import com.example.presentation.ui.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
    fun inject(fragment: FavoritesFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}