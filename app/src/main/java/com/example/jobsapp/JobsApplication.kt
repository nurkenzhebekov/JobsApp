package com.example.jobsapp

import android.app.Application
import com.example.jobsapp.di.AppComponent
import com.example.jobsapp.di.DaggerAppComponent

class JobsApplication : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}