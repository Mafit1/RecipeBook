package com.example.recipebook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Products
import com.example.data.repsitory.FakeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository : FakeRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<Products>>(emptyList())
    val products : StateFlow<List<Products>> = _products


    fun getProducts(query: String) = viewModelScope.launch {
        _products.value = repository.getProducts(query = query)
    }
}