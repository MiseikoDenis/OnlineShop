package com.project.onlineshop.presentation.pageone.sale

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.domain.model.LatestProduct
import com.project.domain.model.SaleProduct
import com.project.onlineshop.databinding.ItemLatestBinding
import com.project.onlineshop.databinding.ItemSaleBinding
import com.project.onlineshop.presentation.pageone.latest.LatestViewHolder
import com.project.onlineshop.presentation.util.GlideImageLoader

class SaleViewHolder private constructor(
    private val binding: ItemSaleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SaleProduct) {
        with(binding) {
            categorySale.text = item.category
            price.text = "$ ${item.price}"
            title.text = item.name
            discount.text = "${item.discount}% off"
            GlideImageLoader.loadImage(item.imageUrl, image)
        }
    }

    companion object {
        fun create(parent: ViewGroup): SaleViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemSaleBinding.inflate(inflater, parent, false)
            return SaleViewHolder(binding)
        }
    }
}