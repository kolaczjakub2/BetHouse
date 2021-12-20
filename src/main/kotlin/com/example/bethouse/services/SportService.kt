package com.example.bethouse.services

import com.example.bethouse.entity.League
import com.example.bethouse.entity.enums.Country
import com.example.bethouse.entity.enums.Sport
import com.example.bethouse.projections.LeagueView
import com.example.bethouse.projections.TeamView
import com.example.bethouse.repositories.LeagueRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class SportService(val leagueRepository: LeagueRepository) {
    fun getSports(): Array<Sport> {
        return Sport.values()
    }

    fun getCountries(sport: Sport): Iterable<Country> {
        return leagueRepository.findBySport(sport).map(League::country).stream().collect(Collectors.toSet())
    }

    fun getLeagues(sport: Sport, country: Country): Iterable<LeagueView> {
        return leagueRepository.findBySportAndCountry(sport, country)
            .map { league -> createLeagueView(league) }.stream().collect(Collectors.toSet())
    }

    private fun createLeagueView(league: League): LeagueView {
        return LeagueView(
            league.id,
            league.name,
            league.participants!!.stream().map { team -> TeamView(team.name) }.collect(Collectors.toSet())
        );
    }
}
