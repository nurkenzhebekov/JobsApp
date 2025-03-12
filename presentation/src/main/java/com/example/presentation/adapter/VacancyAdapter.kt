package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.VacancyDto
import com.example.presentation.R
import com.example.presentation.databinding.ItemVacancyCardBinding

class VacancyAdapter(
    private val vacancies: List<VacancyDto>,
    private val onFavoriteClick: (VacancyDto) -> Unit
) : RecyclerView.Adapter<VacancyAdapter.VacancyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VacancyViewHolder {
        val binding = ItemVacancyCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VacancyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        holder.bind(vacancies[position])
    }

    override fun getItemCount(): Int = vacancies.size

    inner class VacancyViewHolder(private val binding: ItemVacancyCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(vacancy: VacancyDto) {
            binding.apply {
                tvTitle.text = vacancy.title
                tvCompany.text = vacancy.company
                tvLocation.text = vacancy.address?.town
                tvExperience.text = vacancy.experience?.previewText
                tvPublished.text = vacancy.publishedDate

                imgBtIsFavorite.setImageResource(
                    if (vacancy.isFavorite) R.drawable.ic_heart_blue else R.drawable.ic_heart_grey
                )

                imgBtIsFavorite.setOnClickListener {
                    onFavoriteClick(vacancy)
                }
            }
        }
    }
}