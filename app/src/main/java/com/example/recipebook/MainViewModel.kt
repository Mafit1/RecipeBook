package com.example.recipebook

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Product
import com.example.data.repsitory.FakeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository : FakeRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products : StateFlow<List<Product>> = _products

    private val _errorState = MutableStateFlow(false)
    val errorState = _errorState.asStateFlow()

    private val _emptyState = MutableStateFlow(false)
    val emptyState = _emptyState.asStateFlow()

    fun search(query: String) = viewModelScope.launch {
        _errorState.value = false
        _emptyState.value = false
        try {
            val response = repository.searchProducts(query)
            if (response.total == 0) {
                _emptyState.value = true
            }
            _products.value = response.products
        } catch (e: Exception) {
            Log.e("Search query", e.message.toString())
            _errorState.value = true
            _products.value = emptyList()
        }
    }
}