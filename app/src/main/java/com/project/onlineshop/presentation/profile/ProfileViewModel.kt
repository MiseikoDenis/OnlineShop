package com.project.onlineshop.presentation.profile

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.domain.interactor.UserInteractor
import com.project.onlineshop.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val interactor: UserInteractor
) : BaseViewModel() {

    private var _imageUri = MutableLiveData<String>()
    val imageUri: LiveData<String> = _imageUri

    init {
        getInitPhoto()
    }

    fun updateUserPhoto(imageUri: String) {
        viewModelScope.launch {
            interactor.getLoggedInLogin()?.let { interactor.updateUserPhoto(it, imageUri) }
            _imageUri.value = imageUri
        }
    }

    private fun getInitPhoto() {
        viewModelScope.launch {
            interactor.getLoggedInLogin()?.let { login ->
                val user = interactor.getUserByLogin(login)
                if (user?.photoUrl == null) {
                    _imageUri.value =
                        Uri.parse("android.resource://com.project.onlineshop/drawable/ic_placeholder")
                            .toString()
                } else {
                    _imageUri.value = user.photoUrl!!
                }
            }
        }
    }


}