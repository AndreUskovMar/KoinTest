package ru.auskov.kointest.data

class BTConnection {
    fun connect() {
        println("Connect to server via bluetooth")
    }

    fun disconnect() {
        println("Disconnect from server via bluetooth")
    }

    fun sentToServer(data: String) {
        println("Send data to server via bluetooth: $data")
    }

    fun getDataFromServer(): String {
        return "Hello bluetooth"
    }
}