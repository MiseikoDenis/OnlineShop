package com.project.onlineshop.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.onlineshop.presentation.base.BaseViewModel

class LoginViewModel : BaseViewModel() {

    private var _showPassword = MutableLiveData(false)
    val showPassword: LiveData<Boolean>
        get() = _showPassword

    fun togglePasswordVisibility() {
        _showPassword.value = !_showPassword.value!!
    }


}