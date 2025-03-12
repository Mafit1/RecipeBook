package com.example.data.repsitory

import com.example.data.model.Product
import com.example.data.model.SearchResponce
import com.example.data.remote.FakeApi

class FakeRepository(
    private val api : FakeApi
) {
    suspend fun searchProducts(query: String): SearchResponce {
        return api.get(query = query)
    }
}