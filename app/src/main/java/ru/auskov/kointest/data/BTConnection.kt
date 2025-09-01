package ru.auskov.kointest.data

class BTConnection {
    fun connect() {
        println("Connect to server")
    }

    fun disconnect() {
        println("Disconnect from server")
    }

    fun sentToServer(data: String) {
        println("Send data to server: $data")
    }

    fun getDataFromServer(): String {
        return "Get data from server"
    }
}