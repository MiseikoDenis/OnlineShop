package com.project.data.api

import com.google.gson.annotations.SerializedName

data class LatestList(
    @SerializedName("latest")
    val latest: List<ProductResponse>
){
    constructor() : this(emptyList())
}