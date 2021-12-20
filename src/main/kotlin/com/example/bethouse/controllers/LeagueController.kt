package com.example.bethouse.controllers

import com.example.bethouse.entity.League
import com.example.bethouse.entity.Team
import com.example.bethouse.entity.enums.Country
import com.example.bethouse.services.LeagueService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class LeagueController(val leagueService: LeagueService) {

    @GetMapping(value = ["/leagues/{leagueName}/teams"])
    fun getAllTeamByLeague(@PathVariable leagueName: String): ResponseEntity<Iterable<Team>?> {
        return ResponseEntity(leagueService.getAllTeamsByLeagueName(leagueName),HttpStatus.OK)
    }

    @PostMapping("/leagues")
    fun addLeague(@RequestBody request: League): ResponseEntity<League> {
        return ResponseEntity(leagueService.createLeague(request), HttpStatus.CREATED)
    }

    @GetMapping("/leagues/{country}")
    fun getAllLeaguesForCountry(@PathVariable country:Country): ResponseEntity<Iterable<League>?>{
        return ResponseEntity(leagueService.getAllLeaguesForCountry(country),HttpStatus.OK)
    }
}