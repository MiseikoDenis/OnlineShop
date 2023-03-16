package com.project.onlineshop.presentation.pageone.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.domain.item.CategoryItem
import com.project.onlineshop.databinding.ItemCategoryBinding

class CategoryViewHolder private constructor(
    private val binding: ItemCategoryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CategoryItem) {
        binding.image.setImageResource(item.image)
        binding.title.text = item.title
    }

    companion object {
        fun create(parent: ViewGroup): CategoryViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemCategoryBinding.inflate(inflater, parent, false)
            return CategoryViewHolder(binding)
        }
    }
}