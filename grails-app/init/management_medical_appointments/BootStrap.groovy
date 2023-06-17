package management_medical_appointments

import com.fco271292.ConsultingRoom
import com.fco271292.Doctor
import com.fco271292.Patient
import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        createDoctor()
        createConsultingRoom()
        createPatient()
    }
    def destroy = {
    }

    @Transactional
    def createDoctor() {
        if (!Doctor.list()) {
            def doctor = new Doctor(name: "Doctor 1", lastName: "Apellido 1", motherLastName: "Apellido 1", specialty: "Anestesiologia").save(flush: true)
            def doctor2 = new Doctor(name: "Doctor 2", lastName: "Apellido 2", motherLastName: "Apellido 2", specialty: "Dermatologia").save(flush: true)
            def doctor3 = new Doctor(name: "Doctor 3", lastName: "Apellido 3", motherLastName: "Apellido 3", specialty: "Medicina Interna").save(flush: true)
        }
    }

    @Transactional
    def createConsultingRoom() {
        if (!ConsultingRoom.list()) {
            def consultingRoom = new ConsultingRoom(officeNumber: 1, floor: 1).save(flush: true)
            def consultingRoom2 = new ConsultingRoom(officeNumber: 2, floor: 2).save(flush: true)
            def consultingRoom3 = new ConsultingRoom(officeNumber: 3, floor: 3).save(flush: true)
        }
    }

    @Transactional
    def createPatient() {
        if (!Patient.list()) {
            def patient = new Patient(name: "Paciente 1", lastName: "Apellido 1").save(flush: true)
            def patient2 = new Patient(name: "Paciente 2", lastName: "Apellido 1").save(flush: true)
        }

    }
}
