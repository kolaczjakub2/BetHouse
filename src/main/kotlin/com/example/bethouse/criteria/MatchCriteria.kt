package com.example.bethouse.criteria

import com.example.bethouse.entity.enums.Country
import com.example.bethouse.entity.enums.Sport

class MatchCriteria(
    var sport: Sport, var country: Country, var league: String,
    page: Int?, size: Int?, sort: String?, dir: String?
) : PageableCriteria(page, size, sort, dir)