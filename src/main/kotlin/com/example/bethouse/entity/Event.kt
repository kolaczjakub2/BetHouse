package com.example.bethouse.entity

import com.example.bethouse.entity.enums.EventType
import javax.persistence.*

@Entity
class Event(
    val minute: Int,
    @Enumerated(EnumType.STRING)
    val eventType: EventType,
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = true)
    val player: Player,
    @ManyToOne
    @JoinColumn(name = "match_id", nullable = true)
    val match: Match
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null

}