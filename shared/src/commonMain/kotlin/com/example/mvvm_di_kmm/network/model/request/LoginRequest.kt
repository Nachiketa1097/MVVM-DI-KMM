package com.example.mvvm_di_kmm.network.model.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val password: String? = null,
    val username: String? = null
)