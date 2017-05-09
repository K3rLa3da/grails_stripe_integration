package com.matus.stripeExample.customer

class PricingPlan {

    String title
    BigDecimal price
    String pricingStripeId

    static constraints = {
        title nullable: true
        price nullable: true
        pricingStripeId nullable: true
    }

    enum Titles {
        Trial, Silver, Gold
    }

    enum pricingStripeIds {
        Trial, Silver, Gold
    }
    static mapping = {
        table 'pricingPlan'
        version false
        id column: 'id'
        title column: 'title'
    }
}
