package com.example.mvvm_di_kmm.android.ui.screens.note

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NoteScreen(navController: NavController) {
    Column {
        Text(text = "Notes Screen")
    }
}