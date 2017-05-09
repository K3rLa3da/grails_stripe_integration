// Added by the Spring Security Core plugin:
grails {
    plugin {
        springsecurity {
            userLookup {
                userDomainClassName = 'com.matus.stripeExample.auth.User'
                authorityJoinClassName = 'com.matus.stripeExample.auth.UserRole'
            }
            authority {
                className = 'com.matus.stripeExample.auth.Role'
            }
            logout {
                postOnly = false
            }
            successHandler {
                defaultTargetUrl = "/login/showMainPage"
            }
        }
    }
}

grails.plugin.springsecurity.useSecurityEventListener = true
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/customer/**', access: ['ROLE_ADMIN']],
        [pattern: '/user/**', access: ['ROLE_ADMIN']],
        [pattern: '/pricingPlan/**', access: ['ROLE_ADMIN']],
        [pattern: '/subscription/**', access: ['permitAll']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

