package com.example.stateexample.di

import com.example.stateexample.ui.viewmodel.BeerViewModel
import com.example.stateexample.ui.fragment.BeerFragment
import com.example.stateexample.data.repository.BeerRepository
import com.example.stateexample.data.service.BeerService
import org.koin.dsl.module

val appModule = module {
    single {
        BeerRepository(service = get())
    }
    single {
        retrofit.create(BeerService::class.java)
    }
    factory {
        BeerViewModel(repository = get())
    }
    factory {
        BeerFragment()
    }
}