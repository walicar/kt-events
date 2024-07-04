package dev.alicar

import dev.alicar.events.Event
import dev.alicar.events.EventManager

class Client(val name: String) {
    private var token = -1

    init {
        EventManager.addListener("tokenGenerated-${this.name}", this::handleTokenGenerated)
        EventManager.sendEvent(Event("requestToken", this.name))
    }

    private fun handleTokenGenerated(event: Event) {
        this.token = event.data as Int;
        EventManager.sendEvent(Event("tokenAccepted", this.name))
    }

    fun getToken(): Int {
        return this.token
    }

}