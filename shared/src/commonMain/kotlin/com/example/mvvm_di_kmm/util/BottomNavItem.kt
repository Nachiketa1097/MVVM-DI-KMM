package com.example.mvvm_di_kmm.util

import com.example.mvvm_di_kmm.SharedRes
import dev.icerock.moko.resources.ImageResource

sealed class BottomNavScreen(val route: String, val title: String, val icon: ImageResource) {
    object Home : BottomNavScreen(Screen.Home.route, "Home", SharedRes.images.home_56)
    object Product : BottomNavScreen(Screen.Product.route, "Product", SharedRes.images.product_56)
    object Notes : BottomNavScreen(Screen.Notes.route, "Notes", SharedRes.images.notes_56)
}
