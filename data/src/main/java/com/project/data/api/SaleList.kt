package com.project.data.api

import com.google.gson.annotations.SerializedName

data class SaleList(
    @SerializedName("flash_sale")
    val sale: List<SaleProductResponse>
)