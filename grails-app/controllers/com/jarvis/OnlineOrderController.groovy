package com.jarvis

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OnlineOrderController {

    OnlineOrderService onlineOrderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond onlineOrderService.list(params), model:[onlineOrderCount: onlineOrderService.count()]
    }

    def show(Long id) {
        respond onlineOrderService.get(id)
    }

    def create() {
        respond new OnlineOrder(params)
    }

    def save(OnlineOrder onlineOrder) {
        if (onlineOrder == null) {
            notFound()
            return
        }

        try {
            onlineOrderService.save(onlineOrder)
        } catch (ValidationException e) {
            respond onlineOrder.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'onlineOrder.label', default: 'OnlineOrder'), onlineOrder.id])
                redirect onlineOrder
            }
            '*' { respond onlineOrder, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond onlineOrderService.get(id)
    }

    def update(OnlineOrder onlineOrder) {
        if (onlineOrder == null) {
            notFound()
            return
        }

        try {
            onlineOrderService.save(onlineOrder)
        } catch (ValidationException e) {
            respond onlineOrder.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'onlineOrder.label', default: 'OnlineOrder'), onlineOrder.id])
                redirect onlineOrder
            }
            '*'{ respond onlineOrder, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        onlineOrderService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'onlineOrder.label', default: 'OnlineOrder'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'onlineOrder.label', default: 'OnlineOrder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
