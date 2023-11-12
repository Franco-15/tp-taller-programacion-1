package test.integracion.casoUsoGatillar;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;

public class escenarioEncuentros {
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
		
		System.out.println(empleado1.getListaDePostulantes());
		System.out.println(empleado2.getListaDePostulantes());
		System.out.println(empleador1.getListaDePostulantes());
		System.out.println(empleador2.getListaDePostulantes());
		
		System.out.println("Puntaje e1:" + empleado1.getPuntaje());
		System.out.println("Puntaje e2:" + empleado2.getPuntaje());
		System.out.println("Puntaje er1:" + empleador1.getPuntaje());
		System.out.println("Puntaje er2:" + empleador2.getPuntaje());
		
		empleado1.setCandidato(empleador2);
		empleador2.setCandidato(empleado1);
		
		agencia.gatillarRonda();
		
		System.out.println(agencia.);

		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}


}
