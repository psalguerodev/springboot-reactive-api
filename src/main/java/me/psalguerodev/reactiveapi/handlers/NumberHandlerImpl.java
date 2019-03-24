package me.psalguerodev.reactiveapi.handlers;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class NumberHandlerImpl implements NumberHandler {

    @Override
    public Mono<ServerResponse> num(ServerRequest serverRequest) {
        return ServerResponse.ok().body(Mono.just(100), Integer.class);
    }
}
