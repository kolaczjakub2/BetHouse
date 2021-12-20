package com.example.bethouse.entity

import com.example.bethouse.entity.embedded.Person
import com.example.bethouse.entity.enums.Position
import javax.persistence.*

@Entity
class Player(
    val kitNumber: Int,
    @Embedded
    val person: Person,
    @OneToMany
    val events: Set<Event> = emptySet(),
    @ElementCollection
    @Enumerated(EnumType.STRING)
    val positions: Set<Position>
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

}
