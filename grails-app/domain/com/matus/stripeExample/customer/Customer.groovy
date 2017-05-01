package com.matus.stripeExample.customer

import com.matus.stripeExample.auth.User

class Customer {

    User user
    String stripeCustomerId
    String stripeCardId
    String pricingStripeId
    String status

    static constraints = {
        stripeCustomerId nullable: true
        stripeCardId nullable: true
        pricingStripeId nullable: true
        status nullable: true
    }

    enum Status {
        TRIAL, ACTIVE, PENDING_DEACTIVATION, INACTIVE
    }
}
