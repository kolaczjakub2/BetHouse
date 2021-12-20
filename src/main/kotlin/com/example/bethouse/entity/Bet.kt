package com.example.bethouse.entity

import javax.persistence.*

@Entity
class Bet(
    @ManyToOne
    @JoinColumn(name = "homeTeam_id", nullable = false)
    var match: Match?,
    val description: String,
    val mainBet:Boolean
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @OneToMany(cascade = [CascadeType.PERSIST], orphanRemoval = true, mappedBy = "bet")
    val odds : List<Odd> = emptyList()

}