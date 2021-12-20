package com.example.bethouse.controllers

import com.example.bethouse.entity.enums.Country
import com.example.bethouse.entity.enums.Sport
import com.example.bethouse.projections.LeagueView
import com.example.bethouse.services.SportService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SportController(val sportService: SportService) {

    @GetMapping("/sport")
    fun getSports(): ResponseEntity<Array<Sport>> {
        return ResponseEntity(sportService.getSports(), HttpStatus.OK);
    }

    @GetMapping("/sport/{sport}/countries")
    fun getCountries(@PathVariable sport: Sport): ResponseEntity<Iterable<Country>> {
        return ResponseEntity(sportService.getCountries(sport), HttpStatus.OK);
    }

    @GetMapping("/sport/{sport}/countries/{country}")
    fun getLeagues(@PathVariable sport: Sport, @PathVariable country: Country): ResponseEntity<Iterable<LeagueView>> {
        return ResponseEntity(sportService.getLeagues(sport,country), HttpStatus.OK);
    }
}