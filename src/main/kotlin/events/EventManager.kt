package dev.alicar.events

typealias Listener = (Event) -> Unit

class EventManager {
    companion object {
        private val listeners: MutableMap<EventType, MutableList<Listener>> = mutableMapOf()

        fun addListener(eventType: EventType, listener: Listener) {
            if (!listeners.containsKey(eventType)) {
                listeners[eventType] = mutableListOf(listener)
            } else {
                listeners[eventType]?.add(listener)
            }
        }

        fun sendEvent(event: Event) {
            if (!listeners.containsKey(event.type)) {
                return;
            }
            for (listener in listeners[event.type]!!) {
                listener(event)
            }
        }

        fun sendEvent(eventType: EventType) {
            if (!listeners.containsKey(eventType)) {
                return;
            }
            for (listener in listeners[eventType]!!) {
                listener(Event(eventType))
            }
        }
    }
}