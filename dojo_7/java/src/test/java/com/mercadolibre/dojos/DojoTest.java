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

        //assert order.leftToPay().eq(new Money(0.0));
        //assert accountMoney.balance().eq(new Money(123.20));
        assert order.print().equals("Dinero en cuenta: $123.2");
    }

    @Test
    public void test_pay_order_completely_with_credit_card_one_installment() {
        Order order = new Order(new Money(123.20));

        Card card = new Card();

        order.addPayment( card );
        order.pay();

        assert order.print().equals("Tarjeta: $123.2");
    }
	
	@Test
    @Ignore
	public void test_pay_order_completely_with_account_money_and_empty_account_money() {
		Order order = new Order(new Money(123.20));

		AccountMoney accountMoney = new AccountMoney(new Money(123.20));

		order.addPayment(accountMoney);
		order.pay();

        assert order.leftToPay().eq(new Money(0.0));
		assert accountMoney.balance().eq(new Money(0.0));
	}






}
