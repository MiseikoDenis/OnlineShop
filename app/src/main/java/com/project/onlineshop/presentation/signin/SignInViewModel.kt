package com.project.onlineshop.presentation.signin

import android.util.Patterns
import androidx.lifecycle.viewModelScope
import com.project.domain.interactor.UserInteractor
import com.project.domain.model.User
import com.project.onlineshop.presentation.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val interactor: UserInteractor
) : BaseViewModel() {

    fun registerUser(login: String, password: String, email: String){
        viewModelScope.launch{
            val user = User(login, password, email)
            interactor.addUser(user)
        }
    }

    fun checkLogin(login: String): Boolean{
        return runBlocking { interactor.checkLogin(login) }
    }

}
