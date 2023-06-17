package com.fco271292

import grails.gorm.services.Service
import groovy.time.TimeCategory

interface IAppointmentService {

    Appointment get(Serializable id)

    List<Appointment> list(Map args)

    Long count()

    void delete(Serializable id)

    Appointment save(Appointment appointment)

}

@Service(Appointment)
abstract class AppointmentService implements IAppointmentService {
    def validateLimitMedicalAppointments(Doctor doctor){
        def now = new Date()
        def startDate
        use (TimeCategory) {
            startDate = now - 24.hours
        }

        def appointments = Appointment.countByDoctorAndOfficeHoursBetween(doctor, startDate, now)
        log.info "Total ${appointments}"
        if (appointments >= 8) {
            throw new RuntimeException("El doctor no puede tener mas de 8 citas en el día")
        }
    }
    def validateScheduleSameTimeAppointment(Doctor doctor, Date officeHours){
        def appointments = Appointment.findByDoctorAndOfficeHours(doctor, officeHours)
        log.info "--> ${appointments}"
        if (appointments) {
            throw new RuntimeException("No se puede agendar cita para un mismo doctor a la misma hora")
        }
    }
    def validateScheduleAppointmentSameOffice(ConsultingRoom consultingRoom, Date officeHours){
        def appointments = Appointment.findByConsultingRoomAndOfficeHours(consultingRoom, officeHours)
        log.info "--> ${appointments}"
        if (appointments) {
            throw new RuntimeException("No se puede agendar cita en un mismo consultorio a la misma hora")
        }
    }

    def findAllByOfficeHoursAndConsultingRoomAndDoctor(Date officeHours = null, ConsultingRoom consultingRoom, Doctor doctor) {
        def now = new Date()
        def startDate
        def endDate
        try {
            startDate = Date.parse("yyyy-MM-dd HH:mm:ss", "${now[Calendar.YEAR]}-${now[Calendar.MONTH]}-${now[Calendar.DAY_OF_MONTH]} 00:00:00")
        }catch (all) {
            log.error "${all.message}"
        }
        try {
            endDate = Date.parse("yyyy-MM-dd HH:mm:ss", "${now[Calendar.YEAR]}-${now[Calendar.MONTH]}-${now[Calendar.DAY_OF_MONTH]} 23:59:00")
        }catch (all) {
            log.error "${all.message}"
        }

        def appointments = Appointment.findAllByConsultingRoomAndDoctor(consultingRoom, doctor)
    }
}