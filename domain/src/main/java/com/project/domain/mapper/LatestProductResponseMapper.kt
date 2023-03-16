package com.project.domain.mapper

import com.project.data.api.LatestProductResponse
import com.project.domain.model.LatestProduct
import javax.inject.Inject

class LatestProductResponseMapper @Inject constructor() : EntityMapper<LatestProductResponse, LatestProduct> {

    override fun mapFromEntity(entity: LatestProductResponse): LatestProduct {
        return LatestProduct(entity.category, entity.name, entity.price, entity.imageUrl)
    }

    override fun mapToEntity(domain: LatestProduct): LatestProductResponse {
        return LatestProductResponse(domain.category, domain.name, domain.price, domain.imageUrl)
    }
}