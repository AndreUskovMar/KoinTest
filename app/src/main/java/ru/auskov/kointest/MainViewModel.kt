package ru.auskov.kointest

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ru.auskov.kointest.data.MainConnection

class MainViewModel(
    private val mainConnection: MainConnection
): ViewModel() {
    var status = mutableStateOf("Disconnected")

    fun connect() {
        status.value = mainConnection.connect()
    }

    // fun sendData(data: String) {
    //     mainConnection.sentToServer(data)
    // }
}