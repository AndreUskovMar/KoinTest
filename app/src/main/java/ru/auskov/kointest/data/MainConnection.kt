package ru.auskov.kointest.data

class MainConnection(private val btConnection: BTConnection) {
    fun connect(): String {
        println("Connect to server")
        return btConnection.connect()
    }

    fun disconnect() {
        println("Disconnect from server")
        btConnection.disconnect()
    }

    fun sentToServer(data: String) {
        println("Send data to server: $data")
        btConnection.sentToServer(data)
    }

    fun getDataFromServer(): String {
        //return "Hello Kotlin"
        return btConnection.getDataFromServer()
    }
}