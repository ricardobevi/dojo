package com.mercadolibre.dojos;

import com.mercadolibre.dojos.transport.Transport;

import java.util.Arrays;
import java.util.List;

public class Trip implements Transport {

    private List<Transport> transports;

    public Trip(Transport ... transports) {
        this.transports = Arrays.asList(transports);
    }

    public Price cost() {
        return this.transports.stream()
                .map(x -> x.cost())
                .reduce(new Price(), (p1, p2) -> p1.sum(p2) );
    }
}
