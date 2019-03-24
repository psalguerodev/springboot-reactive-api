package me.psalguerodev.reactiveapi.routers;

import me.psalguerodev.reactiveapi.handlers.NumberHandler;
import me.psalguerodev.reactiveapi.handlers.SearchHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Component
public class RouterConfig {

    @Autowired
    private NumberHandler numberHandler;

    @Autowired
    private SearchHandler searchHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        final RouterFunction<ServerResponse> route = RouterFunctions
                .route(RequestPredicates.GET("/num"), numberHandler::num)
                .andRoute(RequestPredicates.GET("/search"), searchHandler::search)
                .andRoute(RequestPredicates.GET("/hotels"), searchHandler::searchHotel);
        return route;
    }

}
