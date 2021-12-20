package com.example.bethouse.dto

import com.example.bethouse.entity.Odd

class CreateBetDTO(val odds : List<Odd>,
                   val description: String,
                   val mainBet:Boolean) {

}
