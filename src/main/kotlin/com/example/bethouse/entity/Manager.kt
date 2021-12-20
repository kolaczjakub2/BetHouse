package com.example.bethouse.entity

import com.example.bethouse.entity.embedded.Person
import javax.persistence.*

@Entity
class Manager(
    @Embedded
    val person: Person
) {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null



}
