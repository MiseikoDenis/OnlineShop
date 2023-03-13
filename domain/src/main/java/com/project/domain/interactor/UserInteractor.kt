package com.project.domain.interactor

import com.project.data.repository.UserRepository
import com.project.domain.mapper.EntityMapper
import com.project.domain.mapper.UserEntityMapper
import com.project.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val repository: UserRepository,
    private val mapper: UserEntityMapper,
) {

    suspend fun getUserByLogin(login: String): User? {
        val user = withContext(Dispatchers.IO) {
            repository.getUser(login)
        } ?: return null
        return mapper.mapFromEntity(user)
    }

    suspend fun addUser(user: User){
        repository.insertUser(mapper.mapToEntity(user))
    }
}