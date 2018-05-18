package steps;

public class Review implements CheckoutStep{
    public SeleccionDeEnvio modificarEnvio() {
        return new SeleccionDeEnvio(new Review());
    }

    public SeleccionDeMedioDePago modificarMedioDePago() {
        return new SeleccionDeMedioDePago(this);
    }
}
