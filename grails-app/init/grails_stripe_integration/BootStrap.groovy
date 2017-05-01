package grails_stripe_integration

import com.matus.stripeExample.auth.Role
import com.matus.stripeExample.auth.User
import com.matus.stripeExample.auth.UserRole
import com.matus.stripeExample.customer.Customer
import com.matus.stripeExample.customer.PricingPlan

class BootStrap {

    def init = { servletContext ->

        Role.AvailableRoles.values().each {
            if (!Role.countByAuthority(it.value())) {
                new Role(authority: it.value()).save(flush: true)
            }
        }

        def roleSystemAdmin = Role.findByAuthority(Role.AvailableRoles.ADMIN.value())
        User admin = User.findByUsername('admin@matus.com') ?: new User(username: 'admin@matus.com', password: '!2Qwerty',
                enabled: true, accountLocked: false, accountExpired: false).save(failOnError: true, flush: true)
        if (!admin?.customer) {
            new Customer(user: admin).save(failOnError: true, flush: true)
        }
        if (!UserRole.findByUserAndRole(admin, roleSystemAdmin)) {
            UserRole.create(admin, roleSystemAdmin)
        }

        [[title: "Trial", price: 0], [title: "Silver", price: 10], [title: "Gold", price: 50]
        ].each {
            if (!PricingPlan.countByTitle(it.title)) {
                new PricingPlan(it).save(flush: true, failOnError: true)
            }
        }
        println User.count()
        println UserRole.count()
        println Role.count()
    }

    def destroy = {
    }
}
