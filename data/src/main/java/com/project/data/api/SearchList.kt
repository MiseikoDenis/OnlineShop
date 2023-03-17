package com.project.data.api

import com.google.gson.annotations.SerializedName

data class SearchList(
    @SerializedName("words")
    val words: List<String>
)