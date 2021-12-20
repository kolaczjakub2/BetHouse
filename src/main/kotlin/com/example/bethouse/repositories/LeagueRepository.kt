package com.example.bethouse.repositories;

import com.example.bethouse.entity.League
import com.example.bethouse.entity.Team
import com.example.bethouse.entity.enums.Country
import com.example.bethouse.entity.enums.Sport
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LeagueRepository : JpaRepository<League, Long> {
    fun findByName(leagueName: String): Optional<League>
    fun findByCountry(country: Country): Iterable<League>
    fun findBySport(sport: Sport): Iterable<League>
    fun findBySportAndCountry(sport: Sport, country: Country): Iterable<League>
    fun findByNameAndCountryAndSport(leagueName: String,  country: Country,sport: Sport,): League
}