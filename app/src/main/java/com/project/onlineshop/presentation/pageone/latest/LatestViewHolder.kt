package com.project.onlineshop.presentation.pageone.latest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.domain.model.Product
import com.project.onlineshop.databinding.ItemLatestBinding

class LatestViewHolder private constructor(
    private val binding: ItemLatestBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Product) {
        binding.text.text = item.category
    }

    companion object {
        fun create(parent: ViewGroup): LatestViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemLatestBinding.inflate(inflater, parent, false)
            return LatestViewHolder(binding)
        }
    }
}