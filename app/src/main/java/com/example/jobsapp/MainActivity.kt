package com.example.jobsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.jobsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.presentation.R as PresentationR

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigation.menu.forEach { item ->
                when (item.itemId) {
                    PresentationR.id.mainFragment -> item.setIcon(
                        if (item.itemId == destination.id) PresentationR.drawable.ic_search_blue else PresentationR.drawable.ic_search_grey
                    )
                    PresentationR.id.favoritesFragment -> item.setIcon(
                        if (item.itemId == destination.id) PresentationR.drawable.ic_heart_blue else PresentationR.drawable.ic_heart_grey
                    )
                }
            }
        }

        binding.bottomNavigation.setupWithNavController(navController)

    }
}