package com.project.onlineshop.presentation.signin

import android.util.Patterns
import com.project.domain.interactor.UserInteractor
import com.project.domain.model.User
import com.project.onlineshop.presentation.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val interactor: UserInteractor
) : BaseViewModel() {

    fun registerUser(login: String, password: String, email: String){
        CoroutineScope(Dispatchers.Main).launch{
            val user = User(login, password, email)
            interactor.addUser(user)
        }
    }

}
