package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class VacanciesAdapter(
    private val onVacancyClick: (Vacancy) -> Unit,
    private val onFavoriteClick: (Vacancy) -> Unit
) : ListAdapter<Vacancy, VacanciesAdapter.VacancyViewHolder>(VacancyDiffCallback()) {

    var showAll: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyViewHolder {
        val binding = ItemVacancyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VacancyViewHolder(binding, onVacancyClick, onFavoriteClick)
    }

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class VacancyViewHolder(
        private val binding: ItemVacancyBinding,
        private val onVacancyClick: (Vacancy) -> Unit,
        private val onFavoriteClick: (Vacancy) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(vacancy: Vacancy) {
            // Отображаем информацию о количестве просмотров, если есть
            binding.tvLookingNumber.text =
                vacancy.lookingNumber?.let { "Сейчас просматривает $it ${declineWord(it)}" } ?: ""
            // Избранное – меняем иконку в зависимости от состояния
            binding.imgBtIsFavorite.setImageResource(
                if (vacancy.isFavorite) R.drawable.ic_heart_filled else R.drawable.ic_heart_grey
            )
            binding.tvTitle.text = vacancy.title
            binding.tvLocation.text = vacancy.address.town
            binding.tvCompany.text = vacancy.company
            binding.tvExperience.text = vacancy.experience.previewText
            binding.tvPublished.text = formatPublishedDate(vacancy.publishedDate)
            binding.btRespond.text = "Откликнуться"

            binding.root.setOnClickListener { onVacancyClick(vacancy) }
            binding.imgBtIsFavorite.setOnClickListener { onFavoriteClick(vacancy) }
        }

        private fun declineWord(number: Int): String {
            // Простейшая логика склонения (при необходимости можно улучшить)
            return if (number == 1) "человек" else "человека"
        }

        private fun formatPublishedDate(date: String): String {
            // Предполагается формат даты "yyyy-MM-dd"
            return try {
                val parsed = LocalDate.parse(date)
                val day = parsed.dayOfMonth
                val month = parsed.month.getDisplayName(TextStyle.FULL, Locale("ru"))
                "Опубликовано $day $month"
            } catch (e: Exception) {
                ""
            }
        }
    }
}

class VacancyDiffCallback : DiffUtil.ItemCallback<Vacancy>() {
    override fun areItemsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Vacancy, newItem: Vacancy): Boolean =
        oldItem == newItem
}