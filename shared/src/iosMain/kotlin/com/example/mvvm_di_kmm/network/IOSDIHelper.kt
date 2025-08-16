package com.example.mvvm_di_kmm.network

import com.example.mvvm_di_kmm.viewmodel.CommonViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class IOSDIHelper : KoinComponent {
    val commonViewModel: CommonViewModel by inject()
}
