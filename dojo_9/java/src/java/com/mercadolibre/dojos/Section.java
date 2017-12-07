package com.mercadolibre.dojos;

import java.math.BigDecimal;

public class Section {

    Place from;
    Place to;

    public Section(Place from, Place to) {

        this.from = from;
        this.to = to;

    }

    public Double distanceInKm() {
        return from.distanceTo(to);
    }
}
