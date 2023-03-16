package com.project.onlineshop.presentation.pageone.latest

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.domain.model.Product
import com.project.onlineshop.R

class LatestAdapter (
    private val items: List<Product>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_latest -> LatestViewHolder.create(parent)
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LatestViewHolder -> holder.bind(items[position])
            else -> throw IllegalArgumentException("Unknown view holder type: ${holder.javaClass.simpleName}")
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = R.layout.item_latest
}