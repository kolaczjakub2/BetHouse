package com.example.bethouse.entity

import com.example.bethouse.entity.embedded.Score
import com.fasterxml.jackson.annotation.JsonBackReference
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Match(
    @ManyToOne(cascade = [CascadeType.PERSIST], optional = false)
    @JoinColumn(name = "homeTeam_id", nullable = false)
    val homeTeam: MatchTeam,
    @ManyToOne(cascade = [CascadeType.PERSIST], optional = false)
    @JoinColumn(name = "awayTeam_id", nullable = false)
    val awayTeam: MatchTeam,
    val dateTime: LocalDateTime,
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "league_id", nullable = true)
    var league: League?,
    @OneToMany(mappedBy = "match")
    var bets: Set<Bet>,
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Embedded
    var score: Score? = null
}