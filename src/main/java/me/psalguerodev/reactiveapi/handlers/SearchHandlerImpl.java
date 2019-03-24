package me.psalguerodev.reactiveapi.handlers;

import me.psalguerodev.reactiveapi.beans.HotelBean;
import me.psalguerodev.reactiveapi.config.Constants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SearchHandlerImpl implements SearchHandler {

    public static final Random random = new Random();

    @Override
    public Mono<ServerResponse> search(ServerRequest serverRequest) {
        Flux<String> results = Flux.merge(
                searchSupplier("Supplier 1"),
                searchSupplier("Supplier 2"),
                searchSupplier("Supplier 3"),
                searchSupplier("Supplier 4")
        );

        return ServerResponse
                .ok()
                .header("Access-Control-Allow-Origin", "*")
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(results, String.class);
    }

    @Override
    public Mono<ServerResponse> searchHotel(ServerRequest serverRequest) {
        Flux<HotelBean> results = Flux.merge(
                searchHotel("Hotel3"),
                searchHotel("Hotel1"),
                searchHotel("Hotel2")
        );

        return ServerResponse
                .ok()
                .header("Access-Control-Allow-Origin", "*")
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(results, HotelBean.class);
    }


    private Flux<String> searchSupplier(String supplierName) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            double randomValue = 10 + (99-10) * random.nextDouble();
            BigDecimal bigDecimalValue = BigDecimal.valueOf(randomValue).setScale(2, BigDecimal.ROUND_HALF_UP);
            list.add(String.format("%s - %s", bigDecimalValue, supplierName));
        }

        return Flux.interval(Duration.ofMillis(random.nextInt(600)))
                .zipWithIterable(list)
                .map(Tuple2::getT2);
    }

    private Flux<HotelBean> searchHotel(String hotelName) {

        for(int i=0; i<8; i++){
            double randomValue = 10 + (99-10) * random.nextDouble();
            BigDecimal bigDecimalValue = BigDecimal.valueOf(randomValue).setScale(2, BigDecimal.ROUND_HALF_UP);
            int index = random.nextInt(Constants.hotels.size());
            Constants.hotels.get(index).setName(bigDecimalValue + " - " + hotelName);
        }

        return Flux.interval(Duration.ofMillis(random.nextInt(400)))
                .zipWithIterable(Constants.hotels)
                .map(Tuple2::getT2);

    }


}
