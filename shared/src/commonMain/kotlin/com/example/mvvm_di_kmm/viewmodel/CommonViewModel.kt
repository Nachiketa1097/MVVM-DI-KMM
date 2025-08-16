package com.example.mvvm_di_kmm.viewmodel

import com.example.mvvm_di_kmm.network.model.request.AddUserRequest
import com.example.mvvm_di_kmm.network.model.request.LoginRequest
import com.example.mvvm_di_kmm.network.model.response.Product
import com.example.mvvm_di_kmm.repository.CommonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommonViewModel(private val repo: CommonRepository) {
    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val _product = MutableStateFlow<List<Product>>(emptyList())
    val product: StateFlow<List<Product>> get() = _product

    fun loadProducts() {
        viewModelScope.launch {
            try {
                _product.value = repo.getProducts()
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                repo.loginUser(loginRequest)
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    fun addUser(addUserRequest: AddUserRequest) {
        viewModelScope.launch {
            try {
                repo.addUser(addUserRequest)
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }


    // Swift-friendly watch function
    fun watchPosts(block: (List<Product>) -> Unit): Job {
        val scope = CoroutineScope(Dispatchers.Main)
        return scope.launch {
            product.collect {
                block(it)
            }
        }
    }
}

