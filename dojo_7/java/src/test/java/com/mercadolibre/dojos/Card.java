package com.mercadolibre.dojos;

public class Card implements PaymentMethod {

    Money withdrawMoney;

    Card(){
        withdrawMoney = new Money(0d);
    }

    public Money contribution(Money maxContribution) {
        withdrawMoney = new Money(maxContribution);
        return maxContribution;
    }

    public Money withdraw(Money amount) {
        withdrawMoney = new Money(amount);
        return amount;
    }

    public String print() {
        return "Tarjeta: " + withdrawMoney.print();
    }
}
