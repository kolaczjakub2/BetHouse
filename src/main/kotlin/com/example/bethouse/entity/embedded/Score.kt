package com.example.bethouse.entity.embedded

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Score(@Column(nullable = true) var homeScore: Int, @Column(nullable = true) var awayScore: Int) {

}
