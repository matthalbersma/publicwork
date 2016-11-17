package onemore

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/movies"(resources: Movie)
        "/"(view:"/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
