package com.fco271292

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ConsultingRoomServiceSpec extends Specification {

    ConsultingRoomService consultingRoomService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ConsultingRoom(...).save(flush: true, failOnError: true)
        //new ConsultingRoom(...).save(flush: true, failOnError: true)
        //ConsultingRoom consultingRoom = new ConsultingRoom(...).save(flush: true, failOnError: true)
        //new ConsultingRoom(...).save(flush: true, failOnError: true)
        //new ConsultingRoom(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //consultingRoom.id
    }

    void "test get"() {
        setupData()

        expect:
        consultingRoomService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ConsultingRoom> consultingRoomList = consultingRoomService.list(max: 2, offset: 2)

        then:
        consultingRoomList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        consultingRoomService.count() == 5
    }

    void "test delete"() {
        Long consultingRoomId = setupData()

        expect:
        consultingRoomService.count() == 5

        when:
        consultingRoomService.delete(consultingRoomId)
        sessionFactory.currentSession.flush()

        then:
        consultingRoomService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ConsultingRoom consultingRoom = new ConsultingRoom()
        consultingRoomService.save(consultingRoom)

        then:
        consultingRoom.id != null
    }
}
