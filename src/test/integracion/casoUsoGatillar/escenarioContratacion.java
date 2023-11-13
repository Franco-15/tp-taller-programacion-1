package test.Integracion.casoUsoGatillar;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Assert;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import util.Mensajes;

public class escenarioContratacion {
	private static Agencia agencia;
	private static EmpleadoPretenso empleado1, empleado2;
	private static Empleador empleador1, empleador2;  
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		agencia = Agencia.getInstance();
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
			100000, 
			Constantes.JORNADA_MEDIA,
			Constantes.MANAGMENT,
			Constantes.EXP_MUCHA,
			Constantes.TERCIARIOS,
			empleado1
		);
		
		agencia.crearTicketEmpleador(Constantes.HOME_OFFICE, 100000, Constantes.JORNADA_MEDIA, Constantes.MANAGMENT, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, empleador1);
		
		agencia.crearTicketEmpleado(Constantes.HOME_OFFICE, 50000,Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.SECUNDARIOS, empleado2);
		
		agencia.crearTicketEmpleador(Constantes.HOME_OFFICE, 50000,Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.SECUNDARIOS, empleador2);
	    
		agencia.gatillarRonda();
		
	}

	@AfterClass
	public static void tearDown() {
	agencia.getEmpleados().clear();

	}
	
	@Test
	public void testEstadoContratacion() {
		Assert.assertEquals(
			"Se esperaba que la agencia este en estado de contratacion.",
			Mensajes.AGENCIA_EN_CONTRATACION.getValor(),
			agencia.getEstado()
		);
	}
	
	@Test
	public void testListaDeAsignaciones() {
		Arrays.asList(
			empleado1.getListaDePostulantes(),
			empleado2.getListaDePostulantes(),
			empleador1.getListaDePostulantes(),
			empleador2.getListaDePostulantes()
		).forEach(lista -> {
			Assert.assertEquals("Se esperaba que la lista de postulantes tenga dos elementos", 2, lista.size());
			double prev = Double.MAX_VALUE;
			for(ClientePuntaje p : lista) {
				Assert.assertTrue(
					"Se esperaba que la lista de postulantes este ordenada por puntaje",
					prev >= p.getPuntaje()
				);
				prev = p.getPuntaje();
			}
		});
		
		
	}
	
	@Test
	public void testPuntajesEsperados() {
		Assert.assertEquals("Puntaje empleado1 equivocado.", 0, empleado1.getPuntaje());
		Assert.assertEquals("Puntaje empleado2 equivocado.", 0, empleado2.getPuntaje());
		Assert.assertEquals("Puntaje empleador1 equivocado.", 10, empleador1.getPuntaje());
		Assert.assertEquals("Puntaje empleador2 equivocado.", 10, empleador2.getPuntaje());
	}


}
