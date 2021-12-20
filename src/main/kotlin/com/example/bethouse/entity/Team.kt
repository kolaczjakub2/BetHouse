package com.example.bethouse.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
class Team(
    val name: String,

    @OneToOne(cascade = [CascadeType.PERSIST], optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    val manager: Manager,
    @JsonManagedReference
    @OneToMany
    var roster: MutableSet<Player> = mutableSetOf()
) {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    val id: Long? = null;
}