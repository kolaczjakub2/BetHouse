package com.example.bethouse.services

import com.example.bethouse.entity.Bet
import com.example.bethouse.exceptions.MatchNotFoundException
import com.example.bethouse.projections.BetView
import com.example.bethouse.repositories.BetRepository
import com.example.bethouse.repositories.MatchRepository
import org.springframework.data.projection.ProjectionFactory
import org.springframework.stereotype.Service

@Service
class BetService(
    val betRepository: BetRepository,
    val matchRepository: MatchRepository,
    val projectionFactory: ProjectionFactory
) {
    fun addBet(bet: Bet, matchId: Long): BetView {
        bet.match = matchRepository.findById(matchId).orElseThrow { throw MatchNotFoundException() }
        betRepository.save(bet)
        return projectionFactory.createProjection(BetView::class.java, bet)
    }

}
