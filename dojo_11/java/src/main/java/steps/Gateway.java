package steps;

public interface Gateway {

	public Object returnSecCodeIfRequiredElse(Tarjeta tarjeta, Object secCode, Object review);

}
