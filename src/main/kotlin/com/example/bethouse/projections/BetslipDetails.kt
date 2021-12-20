package com.example.bethouse.projections

import java.time.LocalDateTime

class BetslipPosition(
    val homeTeam: String,
    val awayTeam: String,
    val dateTime: LocalDateTime,
    val countryLeague: String,
    val leagueName: String,
    val odd: OddView,
    val bet: BetView
)
