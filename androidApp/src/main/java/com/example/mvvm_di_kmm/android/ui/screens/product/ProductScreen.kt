package com.example.mvvm_di_kmm.android.ui.screens.product

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mvvm_di_kmm.viewmodel.CommonViewModel
import org.koin.androidx.compose.get

@Composable
fun ProductScreen(navController: NavController) {
    val viewModel: CommonViewModel = get()
    val posts by viewModel.product.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Posts", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        posts.forEach { post ->
            post.title?.let { Text(it, style = MaterialTheme.typography.bodyLarge) }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}