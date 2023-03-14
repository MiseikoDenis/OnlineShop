package com.project.onlineshop.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.domain.interactor.UserInteractor
import com.project.onlineshop.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val interactor: UserInteractor
) : BaseViewModel() {

    private var _showPassword = MutableLiveData(false)
    val showPassword: LiveData<Boolean> = _showPassword

    fun togglePasswordVisibility() {
        _showPassword.value = !_showPassword.value!!
    }

    fun onLoginClicked(login: String, password: String): Boolean {
        return runBlocking { interactor.checkLoginAndPassword(login, password) }
    }

    fun saveLoggedLogin(login: String){
        interactor.setLoggedInLogin(login)
    }


}