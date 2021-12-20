package com.example.bethouse.controllers

import com.example.bethouse.dto.CreateBetDTO
import com.example.bethouse.entity.Bet
import com.example.bethouse.projections.BetView
import com.example.bethouse.services.BetService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BetController(val betService: BetService) {

    @PostMapping("/match/{matchId}/bet")
    fun addBet(@RequestBody bet: Bet, @PathVariable matchId:Long): ResponseEntity<BetView>{
        return ResponseEntity(betService.addBet(bet,matchId),HttpStatus.CREATED)
    }
}