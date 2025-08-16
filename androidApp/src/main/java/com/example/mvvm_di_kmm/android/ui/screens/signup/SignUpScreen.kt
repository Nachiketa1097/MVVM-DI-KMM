package com.example.mvvm_di_kmm.android.ui.screens.signup

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mvvm_di_kmm.SharedRes
import com.example.mvvm_di_kmm.network.model.request.AddUserRequest
import com.example.mvvm_di_kmm.util.Screen
import com.example.mvvm_di_kmm.viewmodel.CommonViewModel
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc
import org.koin.androidx.compose.get

@Composable
fun SignUpScreen(navController: NavController) {
    val viewModel: CommonViewModel = get()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(text =  StringDesc.Resource(SharedRes.strings.my_string).toString(LocalContext.current), modifier = Modifier.fillMaxWidth())
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
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
                navController.navigate(Screen.Login.route)
                Log.d("ThreeInputScreen", "Username: $username, Email: $email, Password: $password")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}
