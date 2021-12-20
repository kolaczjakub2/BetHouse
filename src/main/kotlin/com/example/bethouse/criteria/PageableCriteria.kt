package com.example.bethouse.criteria

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

open class PageableCriteria(var page: Int? = 1, var size: Int? = 20, var sort: String?, var dir: String?) {
    fun createPageable(): Pageable {
        var sorted = Sort.by("dateTime").ascending()
        if (sort != null) {
            sorted = Sort.by(sort).ascending()
        }
        return PageRequest.of(page!!, size!!, sorted)
    }
}