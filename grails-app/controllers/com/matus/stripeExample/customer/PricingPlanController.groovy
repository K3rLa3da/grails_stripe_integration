package com.matus.stripeExample.customer

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PricingPlanController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PricingPlan.list(params), model:[pricingPlanCount: PricingPlan.count()]
    }

    def show(PricingPlan pricingPlan) {
        respond pricingPlan
    }

    def create() {
        respond new PricingPlan(params)
    }

    @Transactional
    def save(PricingPlan pricingPlan) {
        if (pricingPlan == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pricingPlan.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pricingPlan.errors, view:'create'
            return
        }

        pricingPlan.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pricingPlan.label', default: 'PricingPlan'), pricingPlan.id])
                redirect pricingPlan
            }
            '*' { respond pricingPlan, [status: CREATED] }
        }
    }

    def edit(PricingPlan pricingPlan) {
        respond pricingPlan
    }

    @Transactional
    def update(PricingPlan pricingPlan) {
        if (pricingPlan == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pricingPlan.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pricingPlan.errors, view:'edit'
            return
        }

        pricingPlan.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pricingPlan.label', default: 'PricingPlan'), pricingPlan.id])
                redirect pricingPlan
            }
            '*'{ respond pricingPlan, [status: OK] }
        }
    }

    @Transactional
    def delete(PricingPlan pricingPlan) {

        if (pricingPlan == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pricingPlan.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pricingPlan.label', default: 'PricingPlan'), pricingPlan.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pricingPlan.label', default: 'PricingPlan'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
