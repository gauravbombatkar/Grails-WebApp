package com.jarvis

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AwardController {

    AwardService awardService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond awardService.list(params), model:[awardCount: awardService.count()]
    }

    def show(Long id) {
        respond awardService.get(id)
    }

    def create() {
        respond new Award(params)
    }

    def save(Award award) {
        if (award == null) {
            notFound()
            return
        }

        try {
            awardService.save(award)
        } catch (ValidationException e) {
            respond award.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'award.label', default: 'Award'), award.id])
                redirect award
            }
            '*' { respond award, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond awardService.get(id)
    }

    def update(Award award) {
        if (award == null) {
            notFound()
            return
        }

        try {
            awardService.save(award)
        } catch (ValidationException e) {
            respond award.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'award.label', default: 'Award'), award.id])
                redirect award
            }
            '*'{ respond award, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        awardService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'award.label', default: 'Award'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'award.label', default: 'Award'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
