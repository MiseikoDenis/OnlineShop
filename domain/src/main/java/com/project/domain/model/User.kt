package com.project.domain.model

data class User(
    val login: String,
    val password: String,
    val email: String,
    val photoUrl: String?
)