package com.project.onlineshop.presentation.util

import android.util.Patterns

object EmailValidator {

    fun isValidEmail(text: CharSequence?) =
        text?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() } ?: false
}