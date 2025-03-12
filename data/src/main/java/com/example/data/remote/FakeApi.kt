package com.example.data.remote

import com.example.data.model.Products
import retrofit2.http.GET
import retrofit2.http.Query

interface FakeApi {
    @GET("products/search/")
    suspend fun get(@Query("query") query: String) : List<Products>
}