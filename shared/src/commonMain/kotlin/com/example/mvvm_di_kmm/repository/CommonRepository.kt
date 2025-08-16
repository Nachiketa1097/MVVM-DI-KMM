package com.example.mvvm_di_kmm.repository

import com.example.mvvm_di_kmm.network.model.request.AddUserRequest
import com.example.mvvm_di_kmm.network.model.request.LoginRequest
import com.example.mvvm_di_kmm.network.model.response.Product
import com.example.mvvm_di_kmm.util.APIData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class CommonRepository(private val client: HttpClient) {
    suspend fun getProducts(): List<Product> {
        return client.get(APIData.GET_ALL_PRODUCT).body()
    }

    suspend fun loginUser(loginRequest: LoginRequest) {
        return client.post(APIData.AUTH_LOGIN) {
            contentType(ContentType.Application.Json)
            setBody(loginRequest)
        }.body()
    }

    suspend fun addUser(addUserRequest: AddUserRequest) {
        return client.post(APIData.ADD_USER) {
            contentType(ContentType.Application.Json)
            setBody(addUserRequest)
        }.body()
    }
}
