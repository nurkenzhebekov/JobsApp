package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.data.database.VacancyEntity
import com.example.data.model.VacancyDto
import com.example.presentation.R
import com.example.presentation.databinding.ItemVacancyCardBinding

class VacancyAdapter(
    private val onFavoriteClick: (VacancyEntity) -> Unit
) : ListAdapter<VacancyEntity, VacancyAdapter.VacancyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = VacancyViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_vacancy_card, parent, false)
    )

    override fun onBindViewHolder(holder: VacancyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VacancyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(vacancy: VacancyEntity) {
            itemView.findViewById<TextView>(R.id.tv_title).text = vacancy.title
            itemView.findViewById<ImageView>(R.id.img_bt_is_favorite).apply {
                setImageResource(if (vacancy.isFavorite) R.drawable.ic_heart_blue else R.drawable.ic_heart_grey)
                setOnClickListener { onFavoriteClick(vacancy) }
            }
        }
    }
}