package test.Integracion.CasoUsoTicket;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleModificarTicketsException;
import excepciones.NombreUsuarioException;
import modeloDatos.EmpleadoPretenso;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestEscenarioEstadoContratacionTrue {

    private Agencia agencia = Agencia.getInstance();
    private EmpleadoPretenso empleado;
    @Before
    public void setUp() throws Exception {
        agencia.setEstadoContratacion(true);
        empleado = (EmpleadoPretenso) agencia.registroEmpleado("messias", "1234", "Lionel", "Messi", "123456789", 36);
    }

    @After
    public void tearDown() throws Exception {
    	agencia.getEmpleados().clear();
    	//agencia.cerrarSesion();
    }

    @Test
    public void test_crear_ticket(){
        try {
            agencia.login("messias", "1234");
            agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS, empleado);
            fail("No deberia seguirse ejecutando el programa");
        } catch (ImposibleModificarTicketsException e) {
        }
        catch (ContraException | NombreUsuarioException e) {
            fail("No deberia producirse error al loguerse");
        }
    }
    @Test
    public void test_eliminar_ticket(){
        try {
            agencia.login("messias", "1234");
            agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS, empleado);
            agencia.eliminarTicket();
            fail("No deberia seguirse ejecutando el programa");
        } catch (ImposibleModificarTicketsException e) {
        }
        catch (ContraException | NombreUsuarioException e) {
            fail("No deberia producirse error al loguerse");
        }
    }
    
}

