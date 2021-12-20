package com.example.bethouse.dto

import com.example.bethouse.entity.enums.EventType

data class EventDTO(
    val minute: Int,
    val eventType: EventType,
    val playerId: Long,
) {
}
