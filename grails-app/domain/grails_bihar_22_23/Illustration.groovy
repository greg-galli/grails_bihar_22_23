package grails_bihar_22_23

class Illustration {

    String filename

    static constraints = {
        filename nullable: false, blank: false
    }

    static belongsTo = [annonce: Annonce]
}
