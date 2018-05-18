package steps;

public class GatewayNoSecCode implements Gateway {

	public Object returnSecCodeIfRequiredElse(Tarjeta tarjeta, Object secCode, Object review) {
		return review;
	}
}
