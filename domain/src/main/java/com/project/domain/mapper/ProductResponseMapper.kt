package com.project.domain.mapper

import com.project.data.api.ProductResponse
import com.project.data.db.UserEntity
import com.project.domain.model.Product
import com.project.domain.model.User
import javax.inject.Inject

class ProductResponseMapper @Inject constructor() : EntityMapper<ProductResponse, Product> {

    override fun mapFromEntity(entity: ProductResponse): Product {
        return Product(entity.category, entity.name, entity.price, entity.imageUrl)
    }

    override fun mapToEntity(domain: Product): ProductResponse {
        return ProductResponse(domain.category, domain.name, domain.price, domain.imageUrl)
    }
}