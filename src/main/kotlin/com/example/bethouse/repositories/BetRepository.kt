package com.example.bethouse.repositories;

import com.example.bethouse.entity.Bet
import com.example.bethouse.projections.BetView
import org.springframework.data.jpa.repository.JpaRepository

interface BetRepository : JpaRepository<Bet, Long> {
}