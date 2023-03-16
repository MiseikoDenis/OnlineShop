package com.project.domain.mapper

import com.project.data.api.LatestProductResponse
import com.project.data.api.SaleProductResponse
import com.project.domain.model.LatestProduct
import com.project.domain.model.SaleProduct
import javax.inject.Inject

class SaleProductResponseMapper @Inject constructor() : EntityMapper<SaleProductResponse, SaleProduct> {

    override fun mapFromEntity(entity: SaleProductResponse): SaleProduct {
        return SaleProduct(entity.category, entity.name, entity.price, entity.discount, entity.imageUrl)
    }

    override fun mapToEntity(domain: SaleProduct): SaleProductResponse {
        return SaleProductResponse(domain.category, domain.name, domain.price, domain.discount, domain.imageUrl)
    }
}