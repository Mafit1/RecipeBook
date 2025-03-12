package com.example.data.remote

import com.example.data.model.Product
import com.example.data.model.SearchResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface FakeApi {
    @GET("products/search/")
    suspend fun get(@Query("q") query: String) : SearchResponce
}
