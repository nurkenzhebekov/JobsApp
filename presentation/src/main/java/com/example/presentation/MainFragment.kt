package com.example.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.data.model.VacancyDto
import com.example.presentation.adapter.VacancyAdapter
import com.example.presentation.databinding.FragmentMainBinding
import com.example.presentation.viewmodel.VacancyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var vacancyAdapter: VacancyAdapter
    private val vacancyViewModel: VacancyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vacancyAdapter = VacancyAdapter(emptyList()) { vacancy ->
            toggleFavorite(vacancy)
        }

        binding.rvVacancies.adapter = vacancyAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            vacancyViewModel.vacancies.collect { response ->
                response?.vacancies?.let {
                    vacancyAdapter = VacancyAdapter(it) { vacancy ->
                        toggleFavorite(vacancy)
                    }
                    binding.rvVacancies.adapter = vacancyAdapter
                }
            }
        }
    }

    private fun toggleFavorite(vacancy: VacancyDto) {
        // Обработать изменение избранного
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}