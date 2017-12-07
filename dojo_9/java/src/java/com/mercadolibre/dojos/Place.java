package com.mercadolibre.dojos;

import java.math.BigDecimal;

public class Place {

    private String name;
    private Double distanceFromCongress;

    Place(String name, Double distanceFromCongress){
        this.name = name;
        this.distanceFromCongress = distanceFromCongress;
    }

    Double distanceTo(Place otherPlace){
        return Math.abs(otherPlace.distanceFromCongress - distanceFromCongress);
    }


}
