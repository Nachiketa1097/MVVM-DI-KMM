package com.example.mvvm_di_kmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mvvm_di_kmm.SharedRes
import com.example.mvvm_di_kmm.android.navigation.AppNavGraph
import com.example.mvvm_di_kmm.android.ui.theme.MyApplicationTheme
import com.example.mvvm_di_kmm.res.Strings
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph()
                    val c = StringDesc.Resource(SharedRes.strings.my_string)
                }
            }
        }
    }
}