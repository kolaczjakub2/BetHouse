package com.example.bethouse.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Betslip(
    @ManyToMany
    val odds: MutableSet<Odd>,
    val stake: Float,
    val dateTime: LocalDateTime = LocalDateTime.now()
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null

}