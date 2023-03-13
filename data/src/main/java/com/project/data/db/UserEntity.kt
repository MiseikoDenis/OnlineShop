package com.project.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val login: String,
    val password: String,
    val email: String
)