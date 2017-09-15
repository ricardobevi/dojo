package com.mercadolibre.dojos;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/*
### Venta de items

El objetivo de este dojo es implementar parcialmente el
modelo de medios de pagos para poder desplegar los montos, en la review,
que cada uno de estos aportas a la hora de pagar una orden.

Existen varios medios de pagos:
    - Dinero en cuenta
    - Gift card.
    - TC

La funcionalidad que buscamos implementar **no** cuenta con pruebas y
se busca que decidamos que pruebas deberíamos escribir, ya sean de integración o de unidad.

*/

public class DojoTest {
	
	@Before
	public void setup() {
	}

    @Test
    public void test_pay_order_completely_with_account_money() {
        Order order = new Order(new Money(123.20));

        AccountMoney accountMoney = new AccountMoney(new Money(123.20));

        order.addPayment( accountMoney );

        assert order.print().equals("Dinero en cuenta: $123.2 ");
    }

    @Test
    public void test_pay_order_completely_with_credit_card_one_installment() {
        Order order = new Order(new Money(123.20));

        Card card = new Card();

        order.addPayment( card );

        assert order.print().equals("Tarjeta: $123.2 ");
    }

    @Test
    public void test_pay_order_with_2_payment_methods() {
        Order order = new Order(new Money(200.0));

        AccountMoney accountMoney = new AccountMoney(new Money(100.0));
        Card card = new Card();

        order.addPayment( accountMoney );
        order.addPayment( card );

        assert order.print().equals("Dinero en cuenta: $100.0 Tarjeta: $100.0 ");
    }

    @Test
    public void test_pay_order_with_2_payment_methods_and_shipping() {
        Order order = new Order(new Money(200.0));

        AccountMoney accountMoney = new AccountMoney(new Money(100.0));
        Card card = new Card();

        order.addPayment( accountMoney );
        order.addPayment( card );

        assert order.print().equals("Dinero en cuenta: $100.0 Tarjeta: $100.0 ");

        order.shipWith(new Shipment(new Money(50.0)));

        assert order.print().equals("Dinero en cuenta: $100.0 Tarjeta: $150.0 ");

    }

    @Test
    public void test_pay_order_with_2_payment_methods_in_any_order() {
        Order order = new Order(new Money(200.0));

        AccountMoney accountMoney = new AccountMoney(new Money(100.0));
        Card card = new Card();

        order.addPayment( card );
        order.addPayment( accountMoney );

        assert order.print().equals("Dinero en cuenta: $100.0 Tarjeta: $100.0 ");
    }



    @Test
    public void test_pay_order_with_giftcard() {
        Order order = new Order(new Money(200.0));

        GiftCard giftcard = new GiftCard(new Money(100.0));

        order.addPayment( giftcard );

        assert order.print().equals("GiftCard: $100.0 ");
    }



    @Test
    public void test_pay_order_with_giftcard_and_accountMoney() {
        Order order = new Order(new Money(200.0));

        GiftCard giftcard = new GiftCard(new Money(100.0));
        AccountMoney accountMoney = new AccountMoney(new Money(100.0));

        order.addPayment( giftcard );
        order.addPayment( accountMoney );

        assert order.print().equals("GiftCard: $100.0 Dinero en cuenta: $100.0 ");
    }

    @Test
    public void test_pay_order_with_giftcard_and_accountMoney_and_card() {
        Order order = new Order(new Money(300.0));

        GiftCard giftcard = new GiftCard(new Money(100.0));
        AccountMoney accountMoney = new AccountMoney(new Money(100.0));
        Card card = new Card();

        order.addPayment( card );
        order.addPayment( giftcard );
        order.addPayment( accountMoney );

        assert order.print().equals("GiftCard: $100.0 Dinero en cuenta: $100.0 Tarjeta: $100.0 ");
    }

    @Test
    public void test_pay_order_with_giftcard_and_accountMoney_and_card_with_giftcardCanPay_all() {
        Order order = new Order(new Money(100.0));

        GiftCard giftcard = new GiftCard(new Money(100.0));
        AccountMoney accountMoney = new AccountMoney(new Money(100.0));
        Card card = new Card();

        order.addPayment( card );
        order.addPayment( giftcard );
        order.addPayment( accountMoney );

        assert order.print().equals("GiftCard: $100.0 ");
    }



}
