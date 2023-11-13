package test.modeloNegocio;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class agenciaCrearTicketTest {
	private static Agencia agencia;
	private static Cliente empleado;
	private static Cliente empleador;
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
		
		empleador = agencia.registroEmpleador(
			"b", 
			"bb", 
			"bbb", 
			"12345", 
			Constantes.JURIDICA, 
			Constantes.SALUD
		);
	}
	
	@AfterClass
	public static void tearDown() {
		agencia.getEmpleados().clear();
		agencia.getEmpleadores().clear();

	}

	@Test
	public void testCrearTicketEmpleadoCorrecto() throws Exception {
		agencia.crearTicketEmpleado(
			Constantes.HOME_OFFICE,
			50,
			Constantes.JORNADA_MEDIA,
			Constantes.ADMINISTRADOR,
			Constantes.EXP_MEDIA,
			Constantes.SECUNDARIOS,
			empleado
		);
		Ticket t = empleado.getTicket();
		Assert.assertEquals("locacion incorrecta.", Constantes.HOME_OFFICE, t.getLocacion());
		Assert.assertEquals("remuneracion incorrecta.", 50, t.getRemuneracion());
		Assert.assertEquals("jornada incorrecta.", Constantes.JORNADA_MEDIA, t.getJornada());
		Assert.assertEquals("puesto incorrecto.", Constantes.ADMINISTRADOR, t.getPuesto());
		Assert.assertEquals("experiencia incorrecta.", Constantes.EXP_MEDIA, t.getExperiencia());
		Assert.assertEquals("estudios incorrectos.",Constantes.SECUNDARIOS, t.getEstudios());
	}
	
	@Test
	public void testCrearTicketEmpleadorCorrecto() throws Exception {
		agencia.crearTicketEmpleador(
			Constantes.HOME_OFFICE,
			50,
			Constantes.JORNADA_MEDIA,
			Constantes.ADMINISTRADOR,
			Constantes.EXP_MEDIA,
			Constantes.SECUNDARIOS,
			empleador
		);
		Ticket t = empleador.getTicket();
		Assert.assertEquals("locacion incorrecta.", Constantes.HOME_OFFICE, t.getLocacion());
		Assert.assertEquals("remuneracion incorrecta.", 50, t.getRemuneracion());
		Assert.assertEquals("jornada incorrecta.", Constantes.JORNADA_MEDIA, t.getJornada());
		Assert.assertEquals("puesto incorrecto.", Constantes.ADMINISTRADOR, t.getPuesto());
		Assert.assertEquals("experiencia incorrecta.", Constantes.EXP_MEDIA, t.getExperiencia());
		Assert.assertEquals("estudios incorrectos.",Constantes.SECUNDARIOS, t.getEstudios());
	}
	

}
