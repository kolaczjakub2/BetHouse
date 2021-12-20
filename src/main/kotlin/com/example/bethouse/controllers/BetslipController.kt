package com.example.bethouse.controllers

import com.example.bethouse.dto.CreateBetslipDto
import com.example.bethouse.entity.Betslip
import com.example.bethouse.projections.BetslipPosition
import com.example.bethouse.projections.BetslipView
import com.example.bethouse.services.BetslipService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"])
@RestController
class BetslipController(var betslipService: BetslipService) {

    @PostMapping("user/{userId}/betslip")
    fun placeBet(@RequestBody betslip: CreateBetslipDto, @PathVariable userId: Long): ResponseEntity<BetslipView> {
        return ResponseEntity(betslipService.placeBet(betslip, userId), HttpStatus.CREATED);

    }

    @GetMapping("user/{userId}/betslip")
    fun getBetslips(@PathVariable userId: String): ResponseEntity<List<BetslipView>> {
        return ResponseEntity(betslipService.getBetslip(), HttpStatus.OK);
    }

    @GetMapping("user/{userId}/betslip/{betslipId}")
    fun getBetslipDetails(@PathVariable betslipId:Long, @PathVariable userId: String): ResponseEntity<List<BetslipPosition>> {
        return ResponseEntity(betslipService.getBetslipDetails(betslipId), HttpStatus.OK);
    }

}