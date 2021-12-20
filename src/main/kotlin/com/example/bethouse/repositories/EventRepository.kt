package com.example.bethouse.repositories;

import com.example.bethouse.entity.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<Event, Long> {
}