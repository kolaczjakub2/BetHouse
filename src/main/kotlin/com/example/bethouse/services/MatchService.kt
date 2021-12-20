package com.example.bethouse.services

import com.example.bethouse.criteria.MatchCriteria
import com.example.bethouse.dto.CreateMatchDTO
import com.example.bethouse.dto.EventDTO
import com.example.bethouse.entity.Event
import com.example.bethouse.entity.Match
import com.example.bethouse.entity.MatchTeam
import com.example.bethouse.entity.embedded.Score
import com.example.bethouse.exceptions.*
import com.example.bethouse.projections.BetView
import com.example.bethouse.projections.MatchView
import com.example.bethouse.projections.OddView
import com.example.bethouse.repositories.*
import org.springframework.stereotype.Service
import java.util.stream.Stream

@Service
class MatchService(
    val matchRepository: MatchRepository,
    val teamRepository: TeamRepository,
    val leagueRepository: LeagueRepository,
    val playerRepository: PlayerRepository,
    val eventRepository: EventRepository
) {
    fun createMatch(request: CreateMatchDTO): Match {
        val homeTeam = teamRepository.findById(request.homeTeamId).orElseThrow { throw TeamNotFoundException() }
        val awayTeam = teamRepository.findById(request.awayTeamId).orElseThrow { throw TeamNotFoundException() }
        return matchRepository.save(
            Match(
                MatchTeam(homeTeam, emptySet(), emptySet(), homeTeam.manager),
                MatchTeam(awayTeam, emptySet(), emptySet(), awayTeam.manager),
                request.dateTime,
                leagueRepository.findById(request.leagueId).orElseThrow { throw LeagueNotFoundException() }, emptySet()
            )
        );
    }

    fun addScore(score: Score, matchId: Long): Match {
        val match = matchRepository.findById(matchId).orElseThrow { throw MatchNotFoundException() }
        match.score = score;
        return matchRepository.save(match)
    }

    fun addEvent(event: EventDTO, matchId: Long): Event {
        return eventRepository.save(Event(event.minute, event.eventType,
            playerRepository.findById(event.playerId).orElseThrow { throw PlayerNotFoundException() },
            matchRepository.findById(matchId).orElseThrow { throw MatchNotFoundException() }
        ))
    }

    fun getMatch(matchId: Long): MatchView {
        val match = this.matchRepository.findById(matchId).orElseThrow { throw MatchNotFoundException() }
        return createMatchView(match)
    }

    fun getMatches(matchCriteria: MatchCriteria): Iterable<MatchView> {
        val league = leagueRepository.findByNameAndCountryAndSport(
            matchCriteria.league,
            matchCriteria.country,
            matchCriteria.sport
        )
        return this.matchRepository.findAllByLeague(league, matchCriteria.createPageable())
            .map { match -> createMatchView(match) }.toList();
    }


    private fun createMatchView(match: Match): MatchView {
        return MatchView(
            match.homeTeam.team.name,
            match.awayTeam.team.name,
            match.dateTime,
            match.league!!.name,
            match.league!!.country.name,
            match.bets.stream()
                .map { bet ->
                    BetView(
                        bet.odds.stream().map { odd -> OddView(odd) }.toList(),
                        bet.description,
                        bet.mainBet
                    )
                }.toList()
        )
    }
}
