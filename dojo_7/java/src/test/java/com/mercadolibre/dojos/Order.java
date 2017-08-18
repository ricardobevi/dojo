package com.mercadolibre.dojos;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Money orderValue;
    private Money orderBalance;
    private List<PaymentMethod> paymentMethodList;

    Order(Money orderValue){
        this.paymentMethodList = new ArrayList<PaymentMethod>();
        this.orderValue = orderValue;
        this.orderBalance = orderValue;
    }

    public void addPayment(PaymentMethod paymentMethod) {
        this.paymentMethodList.add(paymentMethod);
    }


    public void pay() {

        for (PaymentMethod paymentMethod: this.paymentMethodList) {
            Money withdrawnMoney = paymentMethod.withdraw(orderBalance);
            orderBalance.minus(withdrawnMoney);
        }

    }

    public Money leftToPay() {
        Money leftToPayMoney = new Money(this.orderValue);

        for (PaymentMethod paymentMethod: this.paymentMethodList) {
            leftToPayMoney.minus(paymentMethod.contribution(leftToPayMoney));
        }

        return leftToPayMoney;
    }

    public String print(){
        String orderPrint = "";

        for (PaymentMethod paymentMethod: this.paymentMethodList) {
            orderPrint += paymentMethod.print();
        }

        return orderPrint;
    }
}
