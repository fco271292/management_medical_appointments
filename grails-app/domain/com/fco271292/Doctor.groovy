package com.fco271292

import java.time.LocalDateTime

class Doctor {

    static constraints = {
        motherLastName nullable: true
        specialty nullable: true
    }

    static hasMany = [appointments: Appointment]

    LocalDateTime dateCreated
    LocalDateTime lastUpdated

    String name
    String lastName
    String motherLastName
    String specialty
}
