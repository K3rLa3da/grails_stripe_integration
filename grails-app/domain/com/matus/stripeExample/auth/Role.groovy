package com.matus.stripeExample.auth

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'authority')
@ToString(includes = 'authority', includeNames = true, includePackage = false)
class Role implements Serializable {

    private static final long serialVersionUID = 1

    String authority

    static constraints = {
        authority blank: false, unique: true
    }

    static mapping = {
        cache true
    }

    enum AvailableRoles {
        ADMIN("ROLE_ADMIN"), USER("ROLE_USER")

        String roleId

        private AvailableRoles(String id) {
            this.roleId = id
        }

        String value() {
            roleId
        }
    }
}
