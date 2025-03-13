package com.example.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.adapter.VacancyAdapter
import com.example.presentation.databinding.FragmentFavoritesBinding
import com.example.presentation.viewmodel.JobViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: JobViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.rvFavVacancies
        val adapter = VacancyAdapter { vacancy -> viewModel.toggleFavorite(vacancy) }

        recyclerView.adapter = adapter
        lifecycleScope.launch {
            viewModel.vacancies.collect { vacancies ->
                adapter.submitList(vacancies.filter { it.isFavorite })
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}