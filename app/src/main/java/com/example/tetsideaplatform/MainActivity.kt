package com.example.tetsideaplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tetsideaplatform.ui.MainScreen
import com.example.tetsideaplatform.ui.theme.TetsIdeaPlatformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TetsIdeaPlatformTheme {
                MainScreen()
            }
        }
    }
}




