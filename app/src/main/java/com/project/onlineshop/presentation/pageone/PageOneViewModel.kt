package com.project.onlineshop.presentation.pageone

import androidx.lifecycle.MutableLiveData
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
    private val interactor: UserInteractor
): BaseViewModel() {

    var text = MutableLiveData("")

    fun getUser(){
        CoroutineScope(Dispatchers.IO).launch {
            text.value = interactor.getUserByLogin("test")?.login
        }
    }

}