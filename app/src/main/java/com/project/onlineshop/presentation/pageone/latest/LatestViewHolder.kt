package com.project.onlineshop.presentation.pageone.latest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.domain.model.LatestProduct
import com.project.onlineshop.databinding.ItemLatestBinding
import com.project.onlineshop.presentation.util.GlideImageLoader

class LatestViewHolder private constructor(
    private val binding: ItemLatestBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: LatestProduct) {
        binding.categoryLatest.text = item.category
        binding.price.text = "$ " + item.price.toString()
        binding.title.text = item.name
        GlideImageLoader.loadImage(item.imageUrl, binding.image)
    }

    companion object {
        fun create(parent: ViewGroup): LatestViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemLatestBinding.inflate(inflater, parent, false)
            return LatestViewHolder(binding)
        }
    }
}