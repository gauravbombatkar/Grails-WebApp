package com.jarvis

import grails.gorm.services.Service

@Service(Award)
interface AwardService {

    Award get(Serializable id)

    List<Award> list(Map args)

    Long count()

    void delete(Serializable id)

    Award save(Award award)

}