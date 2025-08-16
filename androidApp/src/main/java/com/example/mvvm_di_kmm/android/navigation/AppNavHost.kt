package com.example.mvvm_di_kmm.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm_di_kmm.android.ui.screens.login.LoginScreen
import com.example.mvvm_di_kmm.android.ui.screens.signup.SignUpScreen
import com.example.mvvm_di_kmm.util.Screen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.SignUp.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
    }
}
