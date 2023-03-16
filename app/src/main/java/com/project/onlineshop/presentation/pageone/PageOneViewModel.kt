package com.project.onlineshop.presentation.pageone

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.domain.interactor.ProductInteractor
import com.project.domain.interactor.UserInteractor
import com.project.domain.model.LatestProduct
import com.project.domain.model.SaleProduct
import com.project.onlineshop.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PageOneViewModel @Inject constructor(
    private val userInteractor: UserInteractor,
    private val productInteractor: ProductInteractor
): BaseViewModel() {

    private var _imageUri = MutableLiveData<String>()
    val imageUri: LiveData<String> = _imageUri

    private val _latestProducts = MutableLiveData<List<LatestProduct>>()
    val latestProducts: LiveData<List<LatestProduct>> get() = _latestProducts

    private val _saleProducts = MutableLiveData<List<SaleProduct>>()
    val saleProducts: LiveData<List<SaleProduct>> get() = _saleProducts

    init {
        getInitPhoto()
    }

    fun loadAllProducts(){
        loadSaleProducts()
        loadLatestProducts()
    }

    private fun loadLatestProducts() {
        viewModelScope.launch {
            _latestProducts.value = productInteractor.getLatestProducts()
        }
    }

    private fun loadSaleProducts(){
        viewModelScope.launch {
            _saleProducts.value = productInteractor.getSaleProducts()
        }
    }

    private fun getInitPhoto() {
        viewModelScope.launch {
            userInteractor.getLoggedInLogin()?.let { login ->
                val user = userInteractor.getUserByLogin(login)
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