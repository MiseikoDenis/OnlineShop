package com.project.domain.model

data class SaleProduct (
    val category: String,
    val name: String,
    val price: Double,
    val discount: Int,
    val imageUrl: String
)