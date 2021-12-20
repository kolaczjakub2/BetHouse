package com.example.bethouse.services

import com.example.bethouse.dto.CreateBetslipDto
import com.example.bethouse.entity.Betslip
import com.example.bethouse.exceptions.BetslipNotFoundException
import com.example.bethouse.exceptions.BetslipPossibilityWinCounterException
import com.example.bethouse.exceptions.TeamNotFoundException
import com.example.bethouse.projections.*
import com.example.bethouse.repositories.BetslipRepository
import com.example.bethouse.repositories.OddRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

@Service
class BetslipService(val betslipRepository: BetslipRepository, private val oddRepository: OddRepository) {
    private val taxRatio = 0.88f
    fun placeBet(betslipDto: CreateBetslipDto, userId: Long): BetslipView {
        val betslip = Betslip(
            oddRepository.findAllById(betslipDto.oddsId).toMutableSet(),
            betslipDto.stake
        )
        betslipRepository.save(betslip)
        return convertBetslip(betslip)
    }

    fun getBetslip(): List<BetslipView> {
        return this.betslipRepository.findAll().stream().map { betslip -> convertBetslip(betslip) }.toList()
    }

    fun getBetslipDetails(betslipId: Long): List<BetslipPosition> {
        val betslip = this.betslipRepository.findById(betslipId).orElseThrow { throw BetslipNotFoundException() }
        return betslip.odds.stream().map { odd ->
            BetslipPosition(
                odd.bet!!.match!!.homeTeam.team.name,
                odd.bet.match!!.awayTeam.team.name,
                odd.bet.match!!.dateTime,
                odd.bet.match!!.league!!.country.name,
                odd.bet.match!!.league!!.name,
                OddView(odd),
                BetView(emptyList(), odd.bet.description)
            )
        }.toList()
    }


    fun convertBetslip(betslip: Betslip): BetslipView {
        return BetslipView(
            betslip.id!!,
            betslip.stake,
            betslip.dateTime,
            BigDecimal(betslip.stake * taxRatio * betslip.odds.stream()
                .map { odd -> odd.rate }
                .reduce { odd1, odd2 -> odd1 * odd2 }
                .orElseThrow { throw BetslipPossibilityWinCounterException() }.toDouble()
            )
                .setScale(2, RoundingMode.HALF_UP).toFloat()
        )
    }
}

