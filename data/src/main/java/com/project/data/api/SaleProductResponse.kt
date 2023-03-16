package com.project.data.api

import com.google.gson.annotations.SerializedName

data class SaleProductResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("image_url")
    val imageUrl: String
)