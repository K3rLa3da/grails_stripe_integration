package com.matus.stripeExample.customer

class PricingPlan {

    String title
    BigDecimal price
    String pricingStripeId

    static constraints = {
        pricingStripeId nullable: true
    }

    enum Titles {
        Trial, Silver, Gold
    }

    enum pricingStripeIds {
        Trial, Silver, Gold
    }
}
