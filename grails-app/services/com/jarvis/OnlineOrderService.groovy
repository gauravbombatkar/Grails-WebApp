package com.jarvis

import grails.gorm.services.Service

@Service(OnlineOrder)
interface OnlineOrderService {

    OnlineOrder get(Serializable id)

    List<OnlineOrder> list(Map args)

    Long count()

    void delete(Serializable id)

    OnlineOrder save(OnlineOrder onlineOrder)

}