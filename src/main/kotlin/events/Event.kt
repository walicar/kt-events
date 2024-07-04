package dev.alicar.events

typealias EventType = String
data class Event(val type: EventType, val data: Any? = null)