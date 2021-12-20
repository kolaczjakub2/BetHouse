package com.example.bethouse.repositories;

import com.example.bethouse.entity.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository : JpaRepository<Player, Long> {
}