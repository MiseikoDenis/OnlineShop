package com.project.onlineshop.presentation.pageone.sale

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.domain.model.LatestProduct
import com.project.domain.model.SaleProduct
import com.project.onlineshop.R
import com.project.onlineshop.presentation.pageone.latest.LatestViewHolder

class SaleAdapter (
    private val items: List<SaleProduct>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_sale -> SaleViewHolder.create(parent)
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SaleViewHolder -> holder.bind(items[position])
            else -> throw IllegalArgumentException("Unknown view holder type: ${holder.javaClass.simpleName}")
        }
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = R.layout.item_sale
}