package com.example.bethouse

import com.example.bethouse.entity.*
import com.example.bethouse.entity.embedded.Person
import com.example.bethouse.entity.enums.Country
import com.example.bethouse.entity.enums.Position
import com.example.bethouse.entity.enums.Sport
import com.example.bethouse.repositories.*
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import javax.annotation.PostConstruct

@Component
class InitData(
    val teamRepository: TeamRepository, val matchRepository: MatchRepository,
    val leagueRepository: LeagueRepository, val playerRepository: PlayerRepository,
    var betRepository: BetRepository, val oddRepository: OddRepository
) {

    @PostConstruct
    fun initData() {
        val list = listOf(
            Team(
                "Real Madryt", Manager(
                    Person(
                        "Carlo", "Anchelloti",
                        LocalDate.of(1956, Month.JUNE, 10), Country.ITALY
                    )
                )
            ), Team(
                "Wisła Kraków", Manager(
                    Person(
                        "Carlo", "Anchelloti",
                        LocalDate.of(1956, Month.JUNE, 10), Country.ITALY
                    )
                )
            )
        )

        teamRepository.saveAll(list)

        val match = Match(
            MatchTeam(list[0], emptySet(), emptySet(), list[0].manager),
            MatchTeam(list[1], emptySet(), emptySet(), list[0].manager), LocalDateTime.now(), null, emptySet()
        )
        matchRepository.save(match)


        val league = League(setOf(list[0], list[1]), "Championship", Country.WORLDWIDE, Sport.FOOTBALL)
        leagueRepository.save(league)

        val players = listOf(
            Player(
                7,
                Person(
                    "Cristiano",
                    "Ronaldo",
                    LocalDate.of(1985, Month.FEBRUARY, 5),
                    Country.PORTUGAL,
                ),
                emptySet(),
                setOf(Position.ST, Position.RF)
            )
        )
        playerRepository.saveAll(players)

        list[0].roster.add(players[0])
        teamRepository.saveAll(list)
        match.league = league
        matchRepository.save(match)


        val bet = Bet(match, "Match Result", true)

        val bet1 = Bet(match, "2.5+ goals", false)

        betRepository.save(bet)
        betRepository.save(bet1)

        oddRepository.saveAll(
            listOf(
                Odd("Over (2.5)", 1.30f, bet1),
                Odd("Under(2.5)", 3.30f, bet1),
                Odd(match.homeTeam.team.name, 1.30f, bet),
                Odd("Draw", 3.30f, bet),
                Odd(match.awayTeam.team.name, 3.30f, bet)
            )
        )


    }
}