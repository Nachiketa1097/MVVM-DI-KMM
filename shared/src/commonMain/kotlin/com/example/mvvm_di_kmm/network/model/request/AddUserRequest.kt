package com.example.mvvm_di_kmm.network.model.request

import kotlinx.serialization.Serializable

@Serializable
data class AddUserRequest(
    val id: Int? = 0,
    val email: String? = null,
    val password: String? = null,
    val username: String? = null
)