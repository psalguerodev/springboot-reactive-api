package me.psalguerodev.reactiveapi.config;

import me.psalguerodev.reactiveapi.beans.HotelBean;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<HotelBean> hotels = new ArrayList<>();

    static {
        hotels.add(new HotelBean("Shearaton", "Gran Hotel Peruano", 5));
        hotels.add(new HotelBean("El dorado", "Hotel reconocido en Lima", 4));
        hotels.add(new HotelBean("El veripez", "Hotel reconocido", 3));
        hotels.add(new HotelBean("Imperion", "Hotel imperion San Borja", 3));
    }
}
