package com.mercadolibre.dojos;

public class Shipment {

    private Money cost;

    public Shipment(Money cost) {
        this.cost = cost;
    }

    public Money cost() {
        return this.cost;
    }
}
