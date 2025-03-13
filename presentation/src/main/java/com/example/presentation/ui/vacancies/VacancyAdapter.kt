package com.example.presentation.ui.vacancies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.model.Vacancy
import com.example.presentation.databinding.ItemVacancyCardBinding

class VacancyAdapter: ListAdapter<Vacancy, VacancyAdapter.VacancyViewHolder>(VacancyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val binding = ItemVacancyCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VacancyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        val vacancy = getItem(position)
        holder.bind(vacancy)
    }

    class VacancyViewHolder(private val binding: ItemVacancyCardBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(vacancy: Vacancy) {
            binding.tvTitle.text = vacancy.title
            binding.tvCompany.text = vacancy.company
            binding.tvSalary.text = vacancy.salary
            binding.imgBtIsFavorite.setImageResource(
                if (vacancy.isFavorite) android.R.drawable.star_on else android.R.drawable.star_off
            )
        }
    }

    class VacancyDiffCallback : DiffUtil.ItemCallback<Vacancy>() {
        override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean {
            return oldItem == newItem
        }
    }
}