package com.walicar

fun main() {
    val server = Server()
    val clientBob = Client("Bob")
    val clientAlice = Client("Alice")
    println("${clientBob.name} has token id: ${clientBob.getToken()}")
    println("${clientAlice.name} has token id: ${clientAlice.getToken()}")
    println("People who are connected to the server")
    for (client in server.connectedClients) {
        println("   $client")
    }
}