package com.example.bethouse.entity

import com.example.bethouse.entity.enums.Country
import com.example.bethouse.entity.enums.Sport
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
class League(
    @ManyToMany
    var participants: Set<Team>? = emptySet(),
    val name: String,
    @Enumerated(EnumType.STRING)
    val country: Country,
    @Enumerated(EnumType.STRING)
    val sport: Sport,

    @OneToMany(mappedBy = "league")
    @JsonManagedReference
    val matches:Set<Match> = emptySet()
) {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null

}