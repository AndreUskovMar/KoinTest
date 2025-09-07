package ru.auskov.kointest.data

class BTConnection {
    fun connect(): String {
        val status = "Connect to server"
        println(status)
        return status
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