package com.project.data.api

import com.google.gson.annotations.SerializedName

data class LatestProductResponse(
    @SerializedName("category")
    val category: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("image_url")
    val imageUrl: String
)