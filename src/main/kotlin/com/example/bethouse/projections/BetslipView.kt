package com.example.bethouse.projections

import com.example.bethouse.entity.Betslip
import com.example.bethouse.exceptions.BetslipPossibilityWinCounterException
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDateTime

data class BetslipView(val id: Long, val stake: Float, val dateTime: LocalDateTime, val possibilityWin: Float) {


}