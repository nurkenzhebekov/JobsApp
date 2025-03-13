package com.example.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobsapp.JobsApplication
import com.example.presentation.R
import com.example.presentation.databinding.FragmentMainBinding
import com.example.presentation.viewmodel.JobsViewModel
import javax.inject.Inject

class MainFragment : Fragment(R.layout.fragment_main) {

    @Inject
    lateinit var viewModelFactory: androidx.lifecycle.ViewModelProvider.Factory
    private val viewModel: JobsViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var offersAdapter: OffersAdapter
    private lateinit var vacanciesAdapter: VacanciesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as JobsApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentMainBinding.bind(view)

        // Настраиваем горизонтальный список рекомендаций (offers)
        offersAdapter = OffersAdapter { offer ->
            // Открытие ссылки в браузере
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(offer.link)))
        }
        binding.rvOffers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvOffers.adapter = offersAdapter

        // Настраиваем вертикальный список вакансий
        vacanciesAdapter = VacanciesAdapter(
            onVacancyClick = { /* Переход к детальному экрану вакансии (заглушка) */ },
            onFavoriteClick = { vacancy ->
                viewModel.toggleFavorite(vacancy.id)
            }
        )
        binding.rvVacancies.layoutManager = LinearLayoutManager(requireContext())
        binding.rvVacancies.adapter = vacanciesAdapter

        // Кнопка "Еще вакансии" – переключает режим отображения (первые 3 или все)
        binding.btMoreVacancies.setOnClickListener {
            vacanciesAdapter.showAll = true
            vacanciesAdapter.submitList(viewModel.vacancies.value)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.offers.collect { offers ->
                offersAdapter.submitList(offers)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.vacancies.collect { vacancies ->
                // Если режим "показать первые 3", берем подсписок
                val listToShow = if (!vacanciesAdapter.showAll) vacancies.take(3) else vacancies
                vacanciesAdapter.submitList(listToShow)
                binding.tvVacanciesTitle.text = "Вакансии для вас"
                binding.tvVacanciesCount.text = "${vacancies.size} вакансий" // добавить логику склонения при необходимости
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}