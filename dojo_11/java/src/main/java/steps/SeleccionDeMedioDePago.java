package steps;

public class SeleccionDeMedioDePago implements CheckoutStep {

	private CheckoutStep nextStep;
	private Envio envio;

	public SeleccionDeMedioDePago() {
		this.nextStep = new Review();
	}

	public SeleccionDeMedioDePago(CheckoutStep nextStep) {
		this.nextStep = nextStep;
	}

	public SeleccionDeMedioDePago(Envio envio) {
		this.envio = envio;
	}

	public CheckoutStep seleccionarMedioDePago(Rapipago medioDePago){
		return new Review(envio, medioDePago);
	}

	public CheckoutStep tarjetaPreCargada(TarjetaPreCargada tarjetaPreCargada, Gateway gateway) {
		return (CheckoutStep) gateway.returnSecCodeIfRequiredElse(tarjetaPreCargada, new SecCode(nextStep), nextStep);
	}

	public CheckoutStep nuevaTC() {
		return new SecCode(nextStep);
	}
}
