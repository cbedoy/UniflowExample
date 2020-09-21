package com.example.stateexample.di

import com.example.stateexample.BeerDataFlow
import com.example.stateexample.BeerFragment
import com.example.stateexample.BeerRepository
import com.example.stateexample.BeerService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        BeerRepository(service = get())
    }
    single {
        retrofit.create(BeerService::class.java)
    }
    factory {
        BeerDataFlow(repository = get())
    }
    factory {
        BeerFragment()
    }
}