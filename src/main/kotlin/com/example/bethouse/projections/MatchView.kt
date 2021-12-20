package com.example.bethouse.projections

import java.time.LocalDateTime

class MatchView(
    val homeTeam: String,
    val awayTeam: String,
    val dateTime: LocalDateTime,
    val leagueName: String,
    val countryLeague: String,
    val bets: List<BetView>
)