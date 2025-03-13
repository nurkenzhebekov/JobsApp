package com.example.jobsapp

//
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.jobsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Инициализация NavController
        navController = findNavController(R.id.nav_host_fragment)

        // Настройка BottomNavigationView для работы с NavController
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)

        // Добавление listener для навигации
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                com.example.presentation.R.id.mainFragment -> {
                    navController.navigate(com.example.presentation.R.id.mainFragment)
                    true
                }
                com.example.presentation.R.id.favoritesFragment -> {
                    navController.navigate(com.example.presentation.R.id.favoritesFragment)
                    true
                }
                /*R.id.responsesFragment -> {
                    navController.navigate(R.id.responsesFragment)
                    true
                }*/
                /*R.id.messagesFragment -> {
                    navController.navigate(R.id.messagesFragment)
                    true
                }*/
                /*R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }*/
                else -> false
            }
        }
    }
}