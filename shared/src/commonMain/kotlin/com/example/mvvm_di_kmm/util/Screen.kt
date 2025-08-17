package com.example.mvvm_di_kmm.util

sealed class Screen(val route: String) {
    object Login : Screen(Routes.LOGIN)
    object SignUp : Screen(Routes.SIGNUP)
    object Home : Screen(Routes.HOME)
    object Profile : Screen(Routes.PROFILE)
    object Product : Screen(Routes.PRODUCT)
    object Notes : Screen(Routes.NOTES)
}

object Routes {
    const val LOGIN = "login"
    const val SIGNUP = "signup"
    const val HOME = "home"
    const val PROFILE = "profile"
    const val PRODUCT = "product"
    const val NOTES = "notes"
}