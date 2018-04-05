package steps;

public class Review extends CheckoutStep{
    public SeleccionDeEnvio modificarEnvio() {
        CheckoutStep.setEditMode(true);
        return new SeleccionDeEnvio();
    }
}
