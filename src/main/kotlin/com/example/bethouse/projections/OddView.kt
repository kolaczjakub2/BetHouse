package com.example.bethouse.projections

import com.example.bethouse.entity.Odd

class OddView(val id: Long, val description: String, val rate: Float) {
    constructor(odd: Odd?) : this(odd?.id!!, odd.description, odd.rate)
}