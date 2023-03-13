package com.project.data.repository

import com.project.data.db.UserDao
import com.project.data.db.UserEntity
import java.util.*
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun getUser(login: String): UserEntity? {
        return userDao.getUser(login)
    }
}