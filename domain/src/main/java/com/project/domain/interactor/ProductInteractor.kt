package com.project.domain.interactor

import com.project.data.repository.RemoteRepository
import com.project.domain.mapper.ProductResponseMapper
import com.project.domain.model.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductInteractor @Inject constructor(
    private val repository: RemoteRepository,
    private val mapper: ProductResponseMapper
) {
    suspend fun getLatestProducts(): List<Product>{
        return repository.getLatestProducts().map { response->
            mapper.mapFromEntity(response)
        }
    }
}