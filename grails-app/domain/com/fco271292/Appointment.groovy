package com.fco271292


import java.time.LocalDateTime

class Appointment {

    static constraints = {
    }

    static belongsTo = [doctor: Doctor, consultingRoom: ConsultingRoom, patient: Patient]


    LocalDateTime dateCreated
    LocalDateTime lastUpdated

    Date officeHours
}
