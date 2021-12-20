package com.example.bethouse.entity

import com.example.bethouse.entity.enums.Position
import javax.persistence.*

@Entity
class MatchPlayer(
    @ManyToOne
    val player: Player,
    @Enumerated(EnumType.STRING)
    val position: Position
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

}
