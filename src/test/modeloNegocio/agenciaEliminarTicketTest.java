package test.modeloNegocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import excepciones.ImposibleModificarTicketsException;
import junit.framework.Assert;
import modeloDatos.Cliente;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;

public class agenciaEliminarTicketTest {

	private static Agencia agencia;
	private static Cliente empleado;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		agencia = Agencia.getInstance();
		
		empleado = agencia.registroEmpleado(
			"a", //usuario
			"aa",//pass
			"aaa",//nombre
			"aaaa",//apellido
		    "12345",//telefono
			20
		);
		
	
	}
	
	@Before
	public void setUp() throws Exception {
		agencia.crearTicketEmpleado(
				Constantes.HOME_OFFICE,
				50,
				Constantes.JORNADA_MEDIA,
				Constantes.ADMINISTRADOR,
				Constantes.EXP_MEDIA,
				Constantes.SECUNDARIOS,
				empleado
		);
		
		agencia.login("a", "aa");
		
	}
	
	@After
	public void cleanUp() throws Exception {
		if(agencia.getEstado() == Mensajes.AGENCIA_EN_CONTRATACION.getValor()) {
			agencia.gatillarRonda();
		}
	}

	@Test
	public void testEliminarTicketCorrecto() throws Exception {
		agencia.eliminarTicket();
		Assert.assertEquals("Ticket deberia ser null", null, empleado.getTicket());
	}
	
	@Test(expected = ImposibleModificarTicketsException.class)
	public void testEliminarTicketMomentoIncorrecto() throws ImposibleModificarTicketsException {
		agencia.gatillarRonda();
		agencia.eliminarTicket();
		fail("Se esperaba que tirase excepcion.");
	}

}
