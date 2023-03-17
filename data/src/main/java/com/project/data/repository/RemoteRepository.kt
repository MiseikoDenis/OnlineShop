package com.project.data.repository

import com.project.data.api.LatestProductResponse
import com.project.data.api.ProductsApi
import com.project.data.api.SaleProductResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(
    private val api: ProductsApi
) {
    suspend fun getLatestProducts(): List<LatestProductResponse> {
        val response = api.getLatestProducts()
        return response.body()?.latest ?: emptyList()
    }

    suspend fun getSaleProducts(): List<SaleProductResponse>{
        val response = api.getSaleProducts()
        return response.body()?.sale?: emptyList()
    }

    suspend fun getSearchResult(searchItem: String): List<String>{
        val availableWordsResponse = api.getSearchResult()
        val availableWords = availableWordsResponse.body()?.words?: emptyList()
        return availableWords.filter { it.contains(searchItem, ignoreCase = true) }
    }
}