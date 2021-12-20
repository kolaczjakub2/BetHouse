package com.example.bethouse.entity.embedded

import com.example.bethouse.entity.enums.Country
import java.time.LocalDate
import javax.persistence.Embeddable

@Embeddable
class Person(
    var firstName: String,
    var lastName: String,
    var birthDate: LocalDate,
    var country: Country
) {
}
