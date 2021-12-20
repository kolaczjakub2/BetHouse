package com.example.bethouse.dto

import java.time.LocalDateTime

data class CreateMatchDTO(val homeTeamId: Long,
                          val awayTeamId: Long,
                          val dateTime: LocalDateTime,
                          val leagueId: Long
)
