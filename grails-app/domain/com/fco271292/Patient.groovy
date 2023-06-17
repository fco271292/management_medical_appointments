package com.fco271292

import java.time.LocalDateTime

class Patient {

    static constraints = {
        name nullable: true
        lastName nullable: true
    }

    static hasMany = [appointments: Appointment]

    LocalDateTime dateCreated
    LocalDateTime lastUpdated

    String name
    String lastName
}
