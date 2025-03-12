package com.example.data.repsitory

import com.example.data.model.Products
import com.example.data.remote.FakeApi

class FakeRepository(
    private val api : FakeApi
) {
    suspend fun getProducts(query: String): List<Products> {
        return api.get(query = query)

    }
}