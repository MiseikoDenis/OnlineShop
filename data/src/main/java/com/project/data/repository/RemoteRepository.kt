package com.project.data.repository

import com.project.data.api.LatestList
import com.project.data.api.ProductResponse
import com.project.data.api.ProductsApi
import retrofit2.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(
    private val api: ProductsApi
) {
    suspend fun getLatestProducts(): List<ProductResponse> {
        val response = api.getLatestProducts()
        return response.body()?.latest ?: emptyList()
    }
}