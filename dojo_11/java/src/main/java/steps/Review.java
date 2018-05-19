package steps;

public class Review implements CheckoutStep{

	private Envio envio;
	private Rapipago medioDePago;

	@Deprecated
	public Review() {}


	public Review(Envio envio, Rapipago medioDePago) {
		this.envio = envio;
		this.medioDePago = medioDePago;
	}

	public SeleccionDeEnvio modificarEnvio() {
        return new SeleccionDeEnvio(this);
    }

    public SeleccionDeMedioDePago modificarMedioDePago() {
        return new SeleccionDeMedioDePago(this);
    }
}
