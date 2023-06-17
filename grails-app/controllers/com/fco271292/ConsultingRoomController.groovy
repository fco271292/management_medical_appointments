package com.fco271292

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ConsultingRoomController {

    ConsultingRoomService consultingRoomService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond consultingRoomService.list(params), model:[consultingRoomCount: consultingRoomService.count()]
    }

    def show(Long id) {
        respond consultingRoomService.get(id)
    }

    def create() {
        respond new ConsultingRoom(params)
    }

    def save(ConsultingRoom consultingRoom) {
        if (consultingRoom == null) {
            notFound()
            return
        }

        try {
            consultingRoomService.save(consultingRoom)
        } catch (ValidationException e) {
            respond consultingRoom.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'consultingRoom.label', default: 'ConsultingRoom'), consultingRoom.id])
                redirect consultingRoom
            }
            '*' { respond consultingRoom, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond consultingRoomService.get(id)
    }

    def update(ConsultingRoom consultingRoom) {
        if (consultingRoom == null) {
            notFound()
            return
        }

        try {
            consultingRoomService.save(consultingRoom)
        } catch (ValidationException e) {
            respond consultingRoom.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'consultingRoom.label', default: 'ConsultingRoom'), consultingRoom.id])
                redirect consultingRoom
            }
            '*'{ respond consultingRoom, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        consultingRoomService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'consultingRoom.label', default: 'ConsultingRoom'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultingRoom.label', default: 'ConsultingRoom'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
