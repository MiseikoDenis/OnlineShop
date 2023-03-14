package com.project.onlineshop.presentation.pageone

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.domain.interactor.UserInteractor
import com.project.onlineshop.presentation.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PageOneViewModel @Inject constructor(
    val interactor: UserInteractor
): BaseViewModel() {

    var text = MutableLiveData("sdgsdgsdgsdg")

    fun getUser(){
        viewModelScope.launch {
            text.value = interactor.getUserByLogin("test")?.login
        }
    }

}