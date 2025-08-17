package com.example.mvvm_di_kmm.android.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.mvvm_di_kmm.res.Strings
import dev.icerock.moko.resources.StringResource

@Composable
fun getStrings(id: StringResource): String {
    val context = LocalContext.current
    return Strings().get(id).toString(context = context)
}