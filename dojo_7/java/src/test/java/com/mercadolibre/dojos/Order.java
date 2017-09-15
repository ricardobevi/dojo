package com.mercadolibre.dojos;

import java.util.*;

public class Order {

    private Money orderValue;
    private List<PaymentMethod> paymentMethodList;
    private Shipment shipment;

    Order(Money orderValue){
        this.paymentMethodList = new ArrayList<PaymentMethod>();
        this.orderValue = orderValue;
        this.shipment = new Shipment(new Money(0.0));
    }

    public void addPayment(PaymentMethod paymentMethod) {
        this.paymentMethodList.add(paymentMethod);
    }


    public String print(){
        String orderPrint = "";
        Money leftToPayMoney = totalCost();

        Collections.sort(this.paymentMethodList);

        Iterator<PaymentMethod> paymentMethodIterator = this.paymentMethodList.iterator();

        while (!leftToPayMoney.zero() && paymentMethodIterator.hasNext()){
            PaymentMethod paymentMethod = paymentMethodIterator.next();

            orderPrint += paymentMethod.printContribution(leftToPayMoney) + " ";
            leftToPayMoney.minus( paymentMethod.contribution(leftToPayMoney) );

        }

        return orderPrint;
    }

    public void shipWith(Shipment shipment) {
        this.shipment = shipment;
    }

    private Money totalCost() {
        Money totalCost = new Money(this.orderValue);

        totalCost.add(this.shipment.cost());

        return totalCost;
    }


}
