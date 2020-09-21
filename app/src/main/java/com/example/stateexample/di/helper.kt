package com.example.stateexample.di

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
    HttpLoggingInterceptor.Level.BASIC
}).build()

val retrofit: Retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(NetworkResponseAdapterFactory())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl("https://api.punkapi.com/v2/")
    .client(client)
    .build()


