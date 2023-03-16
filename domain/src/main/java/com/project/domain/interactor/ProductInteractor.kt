package com.project.domain.interactor

import com.project.data.repository.RemoteRepository
import com.project.domain.mapper.LatestProductResponseMapper
import com.project.domain.mapper.SaleProductResponseMapper
import com.project.domain.model.LatestProduct
import com.project.domain.model.SaleProduct
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductInteractor @Inject constructor(
    private val repository: RemoteRepository,
    private val latestProductMapper: LatestProductResponseMapper,
    private val saleProductMapper: SaleProductResponseMapper,
) {
    suspend fun getLatestProducts(): List<LatestProduct>{
        return repository.getLatestProducts().map { response->
            latestProductMapper.mapFromEntity(response)
        }
    }

    suspend fun getSaleProducts(): List<SaleProduct>{
        return repository.getSaleProducts().map{response->
            saleProductMapper.mapFromEntity(response)
        }
    }
}