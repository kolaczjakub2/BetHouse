package com.example.bethouse.entity

import javax.persistence.*

@Entity
class MatchTeam(
    @ManyToOne
    @JoinColumn(name = "homeTeam_id", nullable = false)
    val team: Team,

    @ManyToMany
    val mainRoaster: Set<MatchPlayer>,
    @ManyToMany
    val substitution: Set<Player>,

    @OneToOne
    @JoinColumn(name = "manager_id", nullable = false)
    val manager:Manager
) {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

}
