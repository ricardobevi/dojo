import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import steps.SeleccionDeEnvio;
import steps.SeleccionDeMedioDePago;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	@Before
	public void setup() {

	}

	@Test
	public void cuando_EligeAcuerdo_nextStepIs_SeleccionDeMedioDePago() {
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

        seleccionDeEnvio.acuerdo();

        Assert.assertTrue(seleccionDeEnvio.nextStep() instanceof SeleccionDeMedioDePago);
	}

    @Test
    public void cuando_EligeRetiroEnCorreo_nextStepIs_SucursalDeCorreoEnMapa() {
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

        seleccionDeEnvio.acuerdo();

        Assert.assertTrue(seleccionDeEnvio.nextStep() instanceof SeleccionDeMedioDePago);
    }

}
