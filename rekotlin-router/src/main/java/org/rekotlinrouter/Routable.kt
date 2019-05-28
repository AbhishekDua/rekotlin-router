package org.rekotlinrouter

typealias RoutingCompletionHandler = () -> Unit

typealias RouteElementIdentifier = String
typealias Route = List<RouteElementIdentifier>

fun Route.copyRoutes(): Route {
    val copiedRoutes = arrayListOf<RouteElementIdentifier>()
    this.forEach { route ->
        copiedRoutes.add(route)
    }
    return copiedRoutes
}


interface Routable {

    fun pushRouteSegment(routeElementIdentifier: RouteElementIdentifier,
                         animated: Boolean,
                         completionHandler: RoutingCompletionHandler): Routable

    fun popRouteSegment(routeElementIdentifier: RouteElementIdentifier,
                        animated: Boolean,
                        completionHandler: RoutingCompletionHandler)

    fun changeRouteSegment(from: RouteElementIdentifier,
                           to: RouteElementIdentifier,
                           animated: Boolean,
                           completionHandler: RoutingCompletionHandler): Routable
}
