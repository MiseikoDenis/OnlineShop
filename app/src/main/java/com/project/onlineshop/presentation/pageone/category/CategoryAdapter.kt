package com.project.onlineshop.presentation.pageone.category

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.domain.item.CategoryItem
import com.project.onlineshop.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class CategoryAdapter (
    private val items: List<CategoryItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_category -> CategoryViewHolder.create(parent)
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryViewHolder -> holder.bind(items[position])
            else -> throw IllegalArgumentException("Unknown view holder type: ${holder.javaClass.simpleName}")
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = R.layout.item_category
}