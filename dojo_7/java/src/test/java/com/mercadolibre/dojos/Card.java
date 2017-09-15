package com.mercadolibre.dojos;

public class Card implements PaymentMethod {

    Money withdrawMoney;

    Card(){
        withdrawMoney = new Money(0d);
    }

    public PaymentMethodType type() {
        return PaymentMethodType.CARD;
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

    public String printContribution(Money leftToPayMoney) {
        return "Tarjeta: " + this.contribution(leftToPayMoney).print();
    }


    public int compareTo(PaymentMethod paymentMethod) {
        int comparator = 0;

        switch (paymentMethod.type()) {
            case ACCOUNT_MONEY:
                comparator = 1;
                break;
            case GIFTCARD:
                comparator = 1;
                break;
        }

        return comparator;
    }

}
