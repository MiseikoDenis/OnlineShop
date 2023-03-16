package com.project.data.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {
    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestProducts(): Response<LatestList>
}