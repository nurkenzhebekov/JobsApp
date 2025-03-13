package com.example.jobsapp

//
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jobsapp.JobsApplication
import com.example.jobsapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    // Если нужен общий ViewModel factory – можно добавить здесь инъекцию

    override fun onCreate(savedInstanceState: Bundle?) {
        // Инъекция через Dagger
        (application as JobsApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Настройка навигации
        val navController = findNavController(R.id.nav_host_fragment)
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setupWithNavController(navController)

        // (Опционально) можно обновлять badge на иконке "Избранное", если избранное не пустое
    }
}