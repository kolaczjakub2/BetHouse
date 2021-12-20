package com.example.bethouse.repositories;

import com.example.bethouse.entity.Odd
import org.springframework.data.jpa.repository.JpaRepository

interface OddRepository : JpaRepository<Odd, Long> {

}