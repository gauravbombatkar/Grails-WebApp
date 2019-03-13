package com.jarvis

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AwardServiceSpec extends Specification {

    AwardService awardService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Award(...).save(flush: true, failOnError: true)
        //new Award(...).save(flush: true, failOnError: true)
        //Award award = new Award(...).save(flush: true, failOnError: true)
        //new Award(...).save(flush: true, failOnError: true)
        //new Award(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //award.id
    }

    void "test get"() {
        setupData()

        expect:
        awardService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Award> awardList = awardService.list(max: 2, offset: 2)

        then:
        awardList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        awardService.count() == 5
    }

    void "test delete"() {
        Long awardId = setupData()

        expect:
        awardService.count() == 5

        when:
        awardService.delete(awardId)
        sessionFactory.currentSession.flush()

        then:
        awardService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Award award = new Award()
        awardService.save(award)

        then:
        award.id != null
    }
}
