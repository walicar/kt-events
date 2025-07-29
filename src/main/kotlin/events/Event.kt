package com.walicar.events

typealias EventType = String
data class Event(val type: EventType, val data: Any? = null)