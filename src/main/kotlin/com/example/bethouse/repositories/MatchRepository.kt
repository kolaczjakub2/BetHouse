package com.example.bethouse.repositories;

import com.example.bethouse.entity.League
import com.example.bethouse.entity.Match
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchRepository : PagingAndSortingRepository<Match, Long> {
    fun findAllByLeague(league:League, pageable: Pageable): Page<Match>
}