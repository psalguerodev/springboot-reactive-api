package me.psalguerodev.reactiveapi.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface NumberHandler {

    Mono<ServerResponse> num(ServerRequest serverRequest);

}
