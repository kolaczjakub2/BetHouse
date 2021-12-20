package com.example.bethouse.repositories;

import com.example.bethouse.entity.Betslip
import org.springframework.data.jpa.repository.JpaRepository

interface BetslipRepository : JpaRepository<Betslip, Long> {
}