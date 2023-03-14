package com.project.domain.interactor

import com.project.data.repository.UserRepository
import com.project.domain.mapper.UserEntityMapper
import com.project.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
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
        withContext(Dispatchers.IO){
            repository.insertUser(mapper.mapToEntity(user))
        }
    }

    suspend fun checkLoginAndPassword(login: String, password: String): Boolean {
        val user = repository.getUser(login)
        return user?.password == password
    }

    suspend fun checkLogin(login: String): Boolean{
        return repository.getUser(login) == null
    }

    suspend fun updateUserPhoto(login: String, photoUri: String){
        withContext(Dispatchers.IO){
            repository.updateUserPhoto(login, photoUri)
        }
    }

    fun getLoggedInLogin(): String?{
        return repository.getLoggedInUsername()
    }

    fun setLoggedInLogin(login: String?){
        repository.setLoggedInUsername(login)
    }
}