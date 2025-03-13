package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class OffersAdapter(
    private val onOfferClick: (Offer) -> Unit
) : ListAdapter<Offer, OffersAdapter.OfferViewHolder>(OfferDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val binding = ItemOfferBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder(binding, onOfferClick)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class OfferViewHolder(
        private val binding: ItemOfferBinding,
        private val onOfferClick: (Offer) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(offer: Offer) {
            binding.tvOfferTitle.text = offer.title
            // Если есть кнопка, можно отобразить её текст (например, в отдельном TextView)
            binding.tvOfferButton.text = offer.button?.text ?: ""
            binding.root.setOnClickListener { onOfferClick(offer) }
        }
    }
}

class OfferDiffCallback : DiffUtil.ItemCallback<Offer>() {
    override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean =
        oldItem.id == newItem.id && oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean =
        oldItem == newItem
}