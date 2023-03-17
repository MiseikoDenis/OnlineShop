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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PageOneViewModel @Inject constructor(
    private val userInteractor: UserInteractor,
    private val productInteractor: ProductInteractor
): BaseViewModel() {

    private var _imageUri = MutableLiveData<String>()
    val imageUri: LiveData<String> = _imageUri

    private val _latestProducts = MutableLiveData<List<LatestProduct>?>()
    val latestProducts: MutableLiveData<List<LatestProduct>?> get() = _latestProducts

    private val _saleProducts = MutableLiveData<List<SaleProduct>?>()
    val saleProducts: MutableLiveData<List<SaleProduct>?> get() = _saleProducts

    private val isLoading = MutableLiveData<Boolean>().apply { value = false }

    private var _searchResult = MutableLiveData<List<String>>()
    val searchResult: MutableLiveData<List<String>> get() = _searchResult


    init {
        getInitPhoto()
    }

    fun loadData() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val result = productInteractor.loadData()
                _latestProducts.value = result.first
                _saleProducts.value = result.second
            } catch (_: Exception) {
            } finally {
                isLoading.value = false
            }
        }
    }

    fun searchWords(searchTerm: String) {
        viewModelScope.launch {
            delay(1000)
            val searchResult = productInteractor.getSearchResults(searchTerm)
            if (searchResult.isNotEmpty()) {
                val words = searchResult
                _searchResult.postValue(words)
            } else {
                _searchResult.postValue(emptyList())
            }
        }
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