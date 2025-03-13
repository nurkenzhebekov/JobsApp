package com.example.presentation.ui.vacancies

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.databinding.FragmentVacanciesBinding
import com.example.presentation.viewmodel.JobsViewModel
import com.example.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class VacanciesFragment : Fragment(R.layout.fragment_vacancies) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: JobsViewModel
    private lateinit var adapter: VacancyAdapter

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentVacanciesBinding.bind(view)

        viewModel = ViewModelProvider(this, viewModelFactory).get(JobsViewModel::class.java)
        adapter = VacancyAdapter()

        binding.rvVacancies.layoutManager = LinearLayoutManager(requireContext())
        binding.rvVacancies.adapter = adapter

        viewModel.vacancies.observe(viewLifecycleOwner, { vacancies ->
            adapter.submitList(vacancies)
        })

        viewModel.getJobsData()
    }

}