import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
        // Zeplin: https://zpl.io/25zKgWV
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

        CheckoutStep nextStep = seleccionDeEnvio.envioADomicilio();

        // Zeplin: https://zpl.io/br1Km7L
        Assert.assertEquals(SeleccionDeMedioDePago.class, nextStep.getClass());
	}

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioADomicilio_nextStepIs_Review() {
	    // Zeplin: https://zpl.io/be48RDa
        Review review = new Review();

        SeleccionDeEnvio seleccionDeEnvio = review.modificarEnvio();

        CheckoutStep nextStep = seleccionDeEnvio.envioADomicilio();

        Assert.assertEquals(Review.class, nextStep.getClass());
    }

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioASucursal_nextStepIs_SucursalDeCorreo() {
        // Zeplin: https://zpl.io/be48RDa
        Review review = new Review();

        SeleccionDeEnvio seleccionDeEnvio = review.modificarEnvio();

        // Zeplin: https://zpl.io/V10Ye52
        CheckoutStep nextStep = seleccionDeEnvio.retiroEnCorreo();

        Assert.assertEquals(MapaDeSucursales.class, nextStep.getClass());
    }


	@Test
	public void cuando_ModificaMPDesdeReview_ElijeTCPreCargada_GatewaySolicitaSecCode_VuelveAReview(){
		Review review = new Review();
		Gateway gateway = new GatewayToSecCode();
		TarjetaPreCargada tarjetaPreCargada = new TarjetaPreCargada();

		SeleccionDeMedioDePago seleccionDeMedioDePago = review.modificarMedioDePago();

		SecCode secCode = (SecCode) seleccionDeMedioDePago.tarjetaPreCargada(tarjetaPreCargada, gateway);

		CheckoutStep reviewStep = secCode.input(232);

		// Zeplin: https://zpl.io/br1Km7L
		Assert.assertEquals(Review.class, reviewStep.getClass());
	}

	@Test
	public void cuando_ModificaMPDesdeReview_ElijeTCPreCargada_GatewayNoSolicitaSecCode_VuelveAReview(){
		Review review = new Review();
		Gateway gateway = new GatewayNoSecCode();
		TarjetaPreCargada tarjetaPreCargada = new TarjetaPreCargada();

		SeleccionDeMedioDePago seleccionDeMedioDePago = review.modificarMedioDePago();

		CheckoutStep reviewStep = seleccionDeMedioDePago.tarjetaPreCargada(tarjetaPreCargada, gateway);

		// Zeplin: https://zpl.io/br1Km7L
		Assert.assertEquals(Review.class, reviewStep.getClass());
	}


	@Test
	public void cuando_ModificaMPDesdeReview_CargaNuevaTC_SolicitaSecCode_VuelveAReview(){
		Review review = new Review();

		SeleccionDeMedioDePago seleccionDeMedioDePago = review.modificarMedioDePago();

		SecCode secCode = (SecCode) seleccionDeMedioDePago.nuevaTC();

		CheckoutStep reviewStep = secCode.input(232);

		Assert.assertEquals(Review.class, reviewStep.getClass());
	}

/*
	@Test
	public void cuando_(){
		Review review = new Review();

		SeleccionDeMedioDePago seleccionDeMedioDePago = review.modificarMedioDePago();

		SecCode secCode = (SecCode) seleccionDeMedioDePago.nuevaTCViaQR();

		CheckoutStep reviewStep = secCode.input(232);

		Assert.assertEquals(Review.class, reviewStep.getClass());
	}

*/



}
