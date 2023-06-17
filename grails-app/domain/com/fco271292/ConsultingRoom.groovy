package com.fco271292

import java.time.LocalDateTime

class ConsultingRoom {

    static constraints = {
    }

    static hasMany = [appointments: Appointment]

    LocalDateTime dateCreated
    LocalDateTime lastUpdated

    Integer officeNumber
    Integer floor

}
