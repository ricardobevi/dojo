package steps;

public class SeleccionDeEnvio implements CheckoutStep{

	private final CheckoutStep nextStep;

	public SeleccionDeEnvio() {
		this.nextStep = new SeleccionDeMedioDePago();
	}

	public SeleccionDeEnvio(CheckoutStep nextStep) {
		this.nextStep = nextStep;
	}

	public CheckoutStep envioADomicilio() {
        return this.nextStep;
    }

    public CheckoutStep retiroEnCorreo() {
        return new MapaDeSucursales();
    }

	public CheckoutStep seleccionarEnvio(EnvioADomicilio envio){
		return new SeleccionDeMedioDePago(envio);
	}

	public Inconsistencia seleccionarEnvio(Express envio) {
		return new Inconsistencia();
	}
}