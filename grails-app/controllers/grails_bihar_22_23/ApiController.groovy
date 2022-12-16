package grails_bihar_22_23

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured

@Secured('isFullyAuthenticated()')
class ApiController {

    // User Singleton
    // Disponible sur l'url /api/user/id
    // Gestion de GET, PUT, PATCH, DELETE
    def user() {
        switch (request.getMethod()) {
            case "GET":
                if (!params.id)
                    return response.status = 400
                def userInstance = User.get(params.id)
                if (!userInstance)
                    return response.status = 404
                renderThis(userInstance, request.getHeader('Accept'))
                break
            case "PUT":
                break
            case "PATCH":
                break
            case "DELETE":
                break
            default:
                break
        }
    }
    // User Collection
    // Gestion de GET, POST
    def users() {

    }
    // Annonce Singleton
    def annonce() {

    }
    // Annonce Collection
    def annonces() {

    }

    def renderThis(Object object, String accept) {
        switch (accept) {
            case "application/xml":
            case "text/xml":
            case "xml":
                render object as XML
                break
            case "application/json":
            case "text/json":
            case "json":
            default:
                render object as JSON
                break
        }
    }
}
