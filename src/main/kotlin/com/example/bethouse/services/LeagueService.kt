package com.example.bethouse.services

import com.example.bethouse.entity.League
import com.example.bethouse.entity.Team
import com.example.bethouse.entity.enums.Country
import com.example.bethouse.repositories.LeagueRepository
import org.springframework.stereotype.Service

@Service
class LeagueService(val leagueRepository: LeagueRepository) {

    fun getAllTeamsByLeagueName(leagueName: String): Iterable<Team>? {
        return leagueRepository.findByName(leagueName).map { league -> league.participants }.get()
    }

    fun createLeague(request: League): League {
        return leagueRepository.save(request);
    }

    fun getAllLeaguesForCountry(country: Country): Iterable<League> {
        return leagueRepository.findByCountry(country)
    }

}
