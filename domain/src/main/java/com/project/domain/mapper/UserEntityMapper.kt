package com.project.domain.mapper

import com.project.data.db.UserEntity
import com.project.domain.model.User
import javax.inject.Inject

class UserEntityMapper @Inject constructor() : EntityMapper<UserEntity, User> {
    override fun mapFromEntity(entity: UserEntity): User {
        return User(entity.login, entity.password, entity.email)
    }

    override fun mapToEntity(domain: User): UserEntity {
        return UserEntity(domain.login, domain.password, domain.email)
    }
}