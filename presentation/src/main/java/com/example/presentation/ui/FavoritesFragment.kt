package com.example.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobsapp.JobsApplication
import com.example.presentation.R
import com.example.presentation.databinding.FragmentFavoritesBinding
import com.example.presentation.viewmodel.JobsViewModel
import javax.inject.Inject

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    @Inject
    lateinit var viewModelFactory: androidx.lifecycle.ViewModelProvider.Factory
    private val viewModel: JobsViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private lateinit var vacanciesAdapter: VacanciesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as JobsApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentFavoritesBinding.bind(view)

        vacanciesAdapter = VacanciesAdapter(
            onVacancyClick = { /* Заглушка */ },
            onFavoriteClick = { vacancy -> viewModel.toggleFavorite(vacancy.id) }
        )
        binding.rvFavVacancies.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFavVacancies.adapter = vacanciesAdapter

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.vacancies.collect { vacancies ->
                val favorites = vacancies.filter { it.isFavorite }
                vacanciesAdapter.submitList(favorites)
                binding.tvFavVacanciesCount.text = "${favorites.size} ${if (favorites.size == 1) "вакансия" else "вакансии"}"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}