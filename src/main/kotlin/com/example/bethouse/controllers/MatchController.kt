package com.example.bethouse.controllers

import com.example.bethouse.criteria.MatchCriteria
import com.example.bethouse.dto.CreateMatchDTO
import com.example.bethouse.dto.EventDTO
import com.example.bethouse.entity.Event
import com.example.bethouse.entity.Match
import com.example.bethouse.entity.embedded.Score
import com.example.bethouse.projections.MatchView
import com.example.bethouse.services.MatchService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class MatchController(val matchService: MatchService) {

    @PostMapping("/match")
    fun addMatch(@RequestBody request: CreateMatchDTO): ResponseEntity<Match> {
        return ResponseEntity(matchService.createMatch(request), HttpStatus.CREATED)
    }

    @PutMapping("/match/{matchId}/score")
    fun addScore(@RequestBody score: Score, @PathVariable matchId: Long): ResponseEntity<Match> {
        return ResponseEntity(matchService.addScore(score, matchId), HttpStatus.OK)
    }

    @PutMapping("/match/{matchId}/event")
    fun addEvent(@RequestBody event: EventDTO, @PathVariable matchId: Long): ResponseEntity<Event> {
        return ResponseEntity(matchService.addEvent(event, matchId), HttpStatus.OK)
    }


    @GetMapping("/match/{matchId}")
    fun getMatch(@PathVariable matchId: Long): ResponseEntity<MatchView> {
        return ResponseEntity(matchService.getMatch(matchId), HttpStatus.OK);
    }


    @GetMapping("/match")
    fun getMatch(matchCriteria: MatchCriteria): ResponseEntity<Iterable<MatchView>> {
        return ResponseEntity(matchService.getMatches(matchCriteria), HttpStatus.OK);
    }
}