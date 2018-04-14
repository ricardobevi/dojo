import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shippings.EnvioADomicilio;
import shippings.RetiroEnCorreo;
import steps.*;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	@Before
	public void setup() {

	}

	@Test
	public void cuando_EligeEnvioADomicilio_nextStepIs_SeleccionDeMedioDePago() {
	    // Con Precargadas y Dinero En Cuenta o Tarjeta Precargada
        // Paso 1 -> Selecciona Express a Domicilio
        // Paso 2 -> ¿Como quieres pagar? -> Dinero en Cuenta
        // Paso 3 -> Review -> Modificar Envio
        // Paso 4 -> Selecciona Retiro en Sucursal
        // Paso 5 -> Selecciona Sucursal
        // Paso 6 -> Review

	    // Paso 1 -> ¿Como queres recibir el producto? 00_01 -> Enviar a mi ubicacion actual
        // Paso 2 -> Envio a Villa Urquiza 01_01
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio(false);

        CheckoutStep nextStep = seleccionDeEnvio.envioADomicilio();

        Assert.assertEquals(SeleccionDeMedioDePago.class, nextStep.getClass());
	}

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioADomicilio_nextStepIs_Review() {
        Review review = new Review();

        SeleccionDeEnvio seleccionDeEnvio = review.modificarEnvio();

        CheckoutStep nextStep = seleccionDeEnvio.envioADomicilio();

        Assert.assertEquals(Review.class, nextStep.getClass());
    }

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioASucursal_nextStepIs_SucursalDeCorreo() {
        Review review = new Review();

        SeleccionDeEnvio seleccionDeEnvio = review.modificarEnvio();

        CheckoutStep nextStep = seleccionDeEnvio.retiroEnCorreo();

        Assert.assertEquals(MapaDeSucursales.class, nextStep.getClass());
    }
}
