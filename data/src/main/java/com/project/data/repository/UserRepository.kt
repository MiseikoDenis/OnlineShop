package com.project.data.repository

import com.project.data.SharedPreferencesProvider
import com.project.data.db.UserDao
import com.project.data.db.UserEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val sharedPreferencesProvider: SharedPreferencesProvider,
    private val userDao: UserDao
) {

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun getUser(login: String): UserEntity? {
        return userDao.getUser(login)
    }

    suspend fun updateUserPhoto(login: String, photoUri: String) {
        userDao.updateUserPhoto(login, photoUri)
    }

    fun getLoggedInUsername(): String? {
        return sharedPreferencesProvider.getString(KEY_LOGGED_IN_LOGIN, null)
    }

    fun setLoggedInUsername(login: String?) {
        sharedPreferencesProvider.putString(KEY_LOGGED_IN_LOGIN, login)
    }
    companion object {
        private const val KEY_LOGGED_IN_LOGIN = "logged_in_login"
    }
}