package com.project.onlineshop.presentation.signin

import android.util.Patterns
import com.project.onlineshop.presentation.base.BaseViewModel

class SignInViewModel : BaseViewModel() {

    fun isValidEmail(text: CharSequence?) =
        text?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() } ?: false
}
