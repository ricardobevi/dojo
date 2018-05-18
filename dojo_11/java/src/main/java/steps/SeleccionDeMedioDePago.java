package steps;

public class SeleccionDeMedioDePago implements CheckoutStep {

	private CheckoutStep nextStep;

	public SeleccionDeMedioDePago() {
		this.nextStep = new Review();
	}

	public SeleccionDeMedioDePago(CheckoutStep nextStep) {
		this.nextStep = nextStep;
	}

	public CheckoutStep tarjetaPreCargada(TarjetaPreCargada tarjetaPreCargada, Gateway gateway) {
		return (CheckoutStep) gateway.returnSecCodeIfRequiredElse(tarjetaPreCargada, new SecCode(nextStep), nextStep);
	}

	public CheckoutStep nuevaTC() {
		return new SecCode(nextStep);
	}
}
