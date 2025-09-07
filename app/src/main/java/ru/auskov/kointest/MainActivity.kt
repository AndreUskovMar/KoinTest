package ru.auskov.kointest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
// import org.koin.android.ext.android.inject
// import org.koin.java.KoinJavaComponent.getKoin
import ru.auskov.kointest.data.MainConnection
import ru.auskov.kointest.ui.theme.KoinTestTheme


// https://insert-koin.io/docs/quickstart/kotlin

class MainActivity : ComponentActivity(), AndroidScopeComponent {
    // private val mainScope = getKoin().createScope<MainActivity>()
    // private val mainConnection: MainConnection = mainScope.get()

    // private val mainConnection: MainConnection by inject()

    override val scope by activityScope()
    private val mainConnection: MainConnection by scope.inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainConnection.connect()
        mainConnection.sentToServer("Hello Kotlin")
        val data = mainConnection.getDataFromServer()
        println("Received data from server: $data")

        mainConnection.disconnect()

        enableEdgeToEdge()
        setContent {
            KoinTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinTestTheme {
        Greeting("Android")
    }
}