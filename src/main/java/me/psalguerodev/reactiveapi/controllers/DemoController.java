package me.psalguerodev.reactiveapi.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

   @GetMapping("/number")
   public Integer getNumber() {
       return 10;
   }

   @GetMapping("/reactivenumber")
   public Mono<Integer> getReactiveNumber() {
       return Mono.just(10);
   }

   @GetMapping("/numbers")
   public Integer[] getNumbers() throws InterruptedException {
       Integer[] values = new Integer[10];
       for(int i=0; i < values.length; i++) {
           values[i] = i;
           Thread.sleep(500);
       }

       return values;
   }

   @GetMapping(value = "/reactiveNumbers", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
   public Flux<Integer> getReactiveNumbers() {
        return Flux.create(fluxSink -> {
            for(int i=0; i<10; i++){
                try {
                    fluxSink.next(i);
                    Thread.sleep(500);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            fluxSink.complete();
        });

   }

}
