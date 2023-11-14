package test.Integracion.casoUsoGatillar;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;

public class escenarioEncuentros {
	private static Agencia agencia;
	private static EmpleadoPretenso empleado1, empleado2;
	private static Empleador empleador1, empleador2;  
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		agencia = Agencia.getInstance();
		agencia.setEstadoContratacion(false);
		empleado1 = (EmpleadoPretenso) agencia.registroEmpleado(
				"eo1", //usuario
				"aa",//pass
				"empleado1",//nombre
				"aaaa",//apellido
			    "12345",//telefono
				20
		);
		
		empleado2 = (EmpleadoPretenso) agencia.registroEmpleado(
				"eo2", //usuario
				"aa",//pass
				"empleado2",//nombre
				"aaaa",//apellido
			    "12345",//telefono
				20
		);
		
		empleador1 = (Empleador) agencia.registroEmpleador(
			"er1", 
			"bb", 
			"empleador1", 
			"12345", 
			Constantes.JURIDICA, 
			Constantes.SALUD
		);
		
		empleador2 = (Empleador) agencia.registroEmpleador(
			"er2", 
			"bb", 
			"empleador2", 
			"12345", 
			Constantes.JURIDICA, 
			Constantes.SALUD
		);
		
		
		
		agencia.crearTicketEmpleado(
				Constantes.HOME_OFFICE,
				50,
				Constantes.JORNADA_MEDIA,
				Constantes.MANAGMENT,
				Constantes.EXP_MEDIA,
				Constantes.SECUNDARIOS,
				empleado1
		);
		
		agencia.crearTicketEmpleado(
				Constantes.PRESENCIAL,
				100,
				Constantes.JORNADA_MEDIA,
				Constantes.JUNIOR,
				Constantes.EXP_MEDIA,
				Constantes.TERCIARIOS,
				empleado2
		);
		
		agencia.crearTicketEmpleador(
				Constantes.PRESENCIAL,
				40,
				Constantes.JORNADA_MEDIA,
				Constantes.JUNIOR,
				Constantes.EXP_MEDIA,
				Constantes.SECUNDARIOS,
				empleador1
		);
		
	    agencia.crearTicketEmpleador(
				Constantes.PRESENCIAL,
				110,
				Constantes.JORNADA_COMPLETA,
				Constantes.MANAGMENT,
				Constantes.EXP_MUCHA,
				Constantes.TERCIARIOS,
				empleador2
		);
		
	    
		agencia.gatillarRonda();
		
		empleado1.setCandidato(empleador1);
		empleado2.setCandidato(empleador1);
		empleador1.setCandidato(empleado1);
		empleador2.setCandidato(empleado2);
		
		agencia.gatillarRonda();
	}
	
	@AfterClass
	public static void tearDown() {
	agencia.getEmpleados().clear();
	agencia.getEmpleadores().clear();
	}

	@Test
	public void testEstadoContratacion() {
		Assert.assertEquals(
			"Se esperaba que la agencia este en estado de contratacion.",
			Mensajes.AGENCIA_EN_BUSQUEDA.getValor(),
			agencia.getEstado()
		);
	}
	
	@Test
	public void testListaDeAsignacionesVacias() {
		Arrays.asList(
			empleado1.getListaDePostulantes(),
			empleado2.getListaDePostulantes(),
			empleador1.getListaDePostulantes(),
			empleador2.getListaDePostulantes()
		).forEach(lista -> {
			Assert.assertNull(
				"Se esperaba que la lista de postulantes este vacia.",
				lista
			);
		});
	}
	
	@Test
	public void testPuntajesEsperados() {
		Assert.assertEquals(
			"Puntaje empleado1 equivocado.",
			10,
			empleado1.getPuntaje()
		);
		Assert.assertEquals(
			"Puntaje empleado2 equivocado.",
			0,
			empleado1.getPuntaje()
		);
		Assert.assertEquals(
			"Puntaje empleador1 equivocado.",
			60,
			empleado1.getPuntaje()
		);
		Assert.assertEquals(
			"Puntaje empleador2 equivocado.",
			-10,
			empleado1.getPuntaje()
		);
	}
	
	@Test
	public void testContratacionesGeneradas() {
		ArrayList<Contratacion> contrataciones = agencia.getContrataciones();
		Assert.assertEquals(
			"Se esperaba una sola contratacion.",
			1,
			contrataciones.size()
		);
		
		Assert.assertEquals(
			"Se esperaba que la contratacions sea entre empleado 1 y empleador 1.",
			empleador1,
			contrataciones.get(0).getEmpleador()
		);
		
		Assert.assertEquals(
			"Se esperaba que la contratacions sea entre empleado 1 y empleador 1.",
			empleado1,
			contrataciones.get(0).getEmpleado()
		);
		
	}
	
	@Test
	public void testTicketsEliminados() {
		Assert.assertNull(
			"Se debia eliminar el ticket de empleado 1 ya que tubo una contratacion.",
			empleado1.getTicket()
		);
		Assert.assertNull(
			"Se debia de eliminar el ticket del empleador 1 ya que tubo una contratacion",  
			empleador1.getTicket()
		);
	}


}
