package com.fco271292

import grails.gorm.services.Service

@Service(ConsultingRoom)
interface ConsultingRoomService {

    ConsultingRoom get(Serializable id)

    List<ConsultingRoom> list(Map args)

    Long count()

    void delete(Serializable id)

    ConsultingRoom save(ConsultingRoom consultingRoom)

}