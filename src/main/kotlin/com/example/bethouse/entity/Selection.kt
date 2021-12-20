package com.example.bethouse.entity

import javax.persistence.*

@Entity
class Selection(
    @ManyToOne
    @JoinColumn(name="odd_id", nullable=false)
    val odd:Odd) {
    @Id
    @Column(name = "id", nullable = false)
    open var id: Long? = null

}
