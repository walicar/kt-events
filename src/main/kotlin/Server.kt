package dev.alicar

import dev.alicar.events.Event
import dev.alicar.events.EventManager

class Server {
    val connectedClients : MutableSet<String> = mutableSetOf()

    init {
        EventManager.addListener("requestToken", this::handleRequestToken)
        EventManager.addListener("tokenAccepted", this::handleTokenAccepted)
    }

    private fun handleTokenAccepted(event: Event) {
        connectedClients.add(event.data as String)
    }

    private fun handleRequestToken(event: Event) {
        EventManager.sendEvent(Event("tokenGenerated-${event.data as String}", generateToken()))
    }

    private fun generateToken(): Int {
        return (0..10).random()
    }

}