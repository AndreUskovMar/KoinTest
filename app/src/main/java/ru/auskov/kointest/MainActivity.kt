package ru.auskov.kointest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel
import ru.auskov.kointest.ui.theme.KoinTestTheme


// https://insert-koin.io/docs/quickstart/kotlin

class MainActivity : ComponentActivity() {
    // private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewModel.connect()
        // viewModel.sendData("Hello, Andre")

        enableEdgeToEdge()
        setContent {
            KoinTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        ConnectionScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun ConnectionScreen(
    viewModel: MainViewModel = koinViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.connect()
    }

    Text(
        text = "Status: ${viewModel.status.value}!"
    )
}