package com.mercadolibre.dojos;

import java.math.BigDecimal;

public class Price {

    private BigDecimal value;

    public Price(Double value){
        this.value = new BigDecimal(value);
    }

    public Price(BigDecimal value){
        this.value = value;
    }

    public Price() {
        this(0.0);
    }

    public Price multiply(Double number){
        return new Price( this.value.multiply(new BigDecimal(number)) );
    }

    @Override
    public boolean equals(Object otherPrice) {
        Price price = (Price) otherPrice;
        return value.equals(price.value);
    }

    @Override
    public String toString(){
        return value.toString();
    }

    public Price sum(Price price) {
        this.value = this.value.add(price.value);
        return this;
    }
}
