package com.example.mvvm_di_kmm.network.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int? = 0,
    val category: String? = null,
    val description: String? = null,
    val image: String? = null,
    val price: Double? = 0.0,
    val title: String? = null
)