package com.example.mvvm_di_kmm.di

import com.example.mvvm_di_kmm.network.createHttpClient
import com.example.mvvm_di_kmm.repository.CommonRepository
import com.example.mvvm_di_kmm.viewmodel.CommonViewModel
import org.koin.dsl.module

val commonModule = module {
    single { createHttpClient() }
    single { CommonRepository(get()) }
    factory { CommonViewModel(get()) }
}
