package com.project.domain.interactor

import com.project.data.repository.RemoteRepository
import com.project.domain.mapper.LatestProductResponseMapper
import com.project.domain.mapper.SaleProductResponseMapper
import com.project.domain.model.LatestProduct
import com.project.domain.model.SaleProduct
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
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

    @OptIn(DelicateCoroutinesApi::class)
    suspend fun loadData(): Pair<List<LatestProduct>, List<SaleProduct>> {
        val deferredList1 = GlobalScope.async { getLatestProducts() }
        val deferredList2 = GlobalScope.async { getSaleProducts() }
        return Pair(deferredList1.await(), deferredList2.await())
    }

    suspend fun getSearchResults(searchItem: String): List<String>{
        return repository.getSearchResult(searchItem)
    }
}