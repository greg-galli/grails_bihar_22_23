package grails_bihar_22_23

class BootStrap {

    def init = { servletContext ->
        def roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
        def roleModo = new Role(authority: 'ROLE_MOD').save()
        def adminUser = new User(username: "admin", password: "admin").save()
        def modUser = new User(username: "modo", password: "modo").save()
        UserRole.create(adminUser, roleAdmin, true)
        UserRole.create(modUser, roleModo, true)

        ["Zakaria","Aziz","Ferol","Patrice","Alain"].each {
            String uName ->
                def userInstance = new User(username: uName, password: "password")
                (1..5).each {
                    Integer aIndex ->
                        def annonceInstance = new Annonce(
                                title: "Titre annonce $aIndex de $uName",
                                description: "Description annonce $aIndex de $uName",
                                price: 100 * aIndex,
                                isActive: Boolean.TRUE)
                        (1..5).each {
                            annonceInstance.addToIllustrations(new Illustration(filename: "grails.svg"))
                        }
                        userInstance.addToAnnonces(annonceInstance)
                }
            userInstance.save(flush: true, failOnError: true)
        }
    }
    def destroy = {
    }
}
