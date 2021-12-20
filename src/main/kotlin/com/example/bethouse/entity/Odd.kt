package com.example.bethouse.entity

import javax.persistence.*

@Entity
class Odd(
    val description: String,
    val rate: Float,
    @ManyToOne
    val bet: Bet?
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null

}
