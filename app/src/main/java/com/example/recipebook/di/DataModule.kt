package com.example.recipebook.di

import com.example.data.remote.UserAPI
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single<UserRepository> {
        UserRepositoryImpl(
            api = get()
        )
    }

    single<UserAPI> {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
    }
}