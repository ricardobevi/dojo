package com.mercadolibre.dojos.transport;

import com.mercadolibre.dojos.Price;
import com.mercadolibre.dojos.Section;

public class Bus implements Transport {

    static private Price pricePerKm = new Price(10.00);

    private Section section;

    public Bus(Section section){
        this.section = section;
    }

    public Price cost() {
        return pricePerKm.multiply( section.distanceInKm() );
    }
}
