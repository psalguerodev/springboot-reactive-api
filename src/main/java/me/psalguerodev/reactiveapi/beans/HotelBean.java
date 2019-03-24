package me.psalguerodev.reactiveapi.beans;

import java.io.Serializable;

public class HotelBean implements Serializable {

    private static final long serialVersionUID = 2420392216172111593L;

    private String name;
    private String shortDescription;
    private int amountStars;

    public HotelBean(String name, String shortDescription, int amountStars) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.amountStars = amountStars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getAmountStars() {
        return amountStars;
    }

    public void setAmountStars(int amountStars) {
        this.amountStars = amountStars;
    }

    @Override
    public String toString() {
        return "HotelBean{" +
                "name='" + name + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", amountStars=" + amountStars +
                '}';
    }
}
