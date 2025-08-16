package com.example.mvvm_di_kmm.android.ui.screens.login

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mvvm_di_kmm.network.model.request.AddUserRequest
import com.example.mvvm_di_kmm.viewmodel.CommonViewModel
import org.koin.androidx.compose.get

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: CommonViewModel = get()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier
    .fillMaxSize()
    .statusBarsPadding()
    .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                val addUserRequest = AddUserRequest(
                    email = email,
                    username = username,
                    password = password
                )
                viewModel.addUser(addUserRequest)
                Log.d("ThreeInputScreen", "Username: $username, Email: $email, Password: $password")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}