package steps;

public class GatewayToSecCode implements Gateway {
	public Object returnSecCodeIfRequiredElse(Tarjeta tarjeta, Object secCode, Object review) {
		return new SecCode((CheckoutStep) review);
	}
}
