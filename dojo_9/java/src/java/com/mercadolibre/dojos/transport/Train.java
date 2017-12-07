package com.mercadolibre.dojos.transport;

import com.mercadolibre.dojos.Price;
import com.mercadolibre.dojos.Section;

public class Train implements Transport{
    static private Price pricePerKm = new Price(5.00);

    private Section section;

    public Train(Section section){
        this.section = section;
    }

    public Price cost() {
        return pricePerKm.multiply( section.distanceInKm() );
    }
}
