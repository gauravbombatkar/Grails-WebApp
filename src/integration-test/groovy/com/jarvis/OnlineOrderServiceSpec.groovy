package com.jarvis

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OnlineOrderServiceSpec extends Specification {

    OnlineOrderService onlineOrderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new OnlineOrder(...).save(flush: true, failOnError: true)
        //new OnlineOrder(...).save(flush: true, failOnError: true)
        //OnlineOrder onlineOrder = new OnlineOrder(...).save(flush: true, failOnError: true)
        //new OnlineOrder(...).save(flush: true, failOnError: true)
        //new OnlineOrder(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //onlineOrder.id
    }

    void "test get"() {
        setupData()

        expect:
        onlineOrderService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<OnlineOrder> onlineOrderList = onlineOrderService.list(max: 2, offset: 2)

        then:
        onlineOrderList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        onlineOrderService.count() == 5
    }

    void "test delete"() {
        Long onlineOrderId = setupData()

        expect:
        onlineOrderService.count() == 5

        when:
        onlineOrderService.delete(onlineOrderId)
        sessionFactory.currentSession.flush()

        then:
        onlineOrderService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        OnlineOrder onlineOrder = new OnlineOrder()
        onlineOrderService.save(onlineOrder)

        then:
        onlineOrder.id != null
    }
}
