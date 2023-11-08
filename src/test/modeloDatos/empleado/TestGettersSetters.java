package test.modeloDatos.empleado;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import util.Constantes;

public class TestGettersSetters {
	
	private EmpleadoPretenso empleado;
	
	@Before
	public void setUp() {
		empleado = new EmpleadoPretenso("Messi10", "1234", "jose", "123456789", "rodriguez", 20);
	}
	
	@Test
	public void test_get_set_apellido_no_vacio() {
		this.empleado.setApellido("rodriguez");
		Assert.assertEquals("El apellido del empleado no coincide", "rodriguez", this.empleado.getApellido());
	}
	
	@Test
	public void test_get_set_apellido_vacio() {
		this.empleado.setApellido("");
		Assert.assertEquals("El apellido del empleado no coincide", "", this.empleado.getApellido());
	}
	
	@Test
	public void test_get_set_edad() {
		this.empleado.setEdad(1);
		Assert.assertEquals("La edad del empleado no coincide",1, this.empleado.getEdad());
		
	}
	
	@Test
	public void test_get_set_candidato() {
		Empleador empleador = new Empleador("cr7","1234", "carlos ulsa","123456987", Constantes.SALUD, Constantes.JURIDICA);
		this.empleado.setCandidato(empleador);
		Assert.assertEquals("El candidato del empleado no coincide",empleador, this.empleado.getCandidato());
	}
	
	@Test
	public void test_get_set_lista_postulantes() {
		
	}
	
	@Test
	public void test_get_set_puntaje_positivo() {
		this.empleado.setPuntaje(1);
		Assert.assertEquals("El puntaje del empleado deberia ser positivo",1, this.empleado.getPuntaje());
	}
	
	@Test
	public void test_get_set_puntaje_cero() {
		this.empleado.setPuntaje(0);
		Assert.assertEquals("El puntaje del empleado deberia ser cero",0, this.empleado.getPuntaje());
	}
	
	@Test
	public void test_get_set_puntaje_negativo() {
		this.empleado.setPuntaje(-1);
		Assert.assertEquals("El puntaje del empleado deberia ser negativo",-1, this.empleado.getPuntaje());
	}
	
	@Test
	public void test_get_set_ticket() {
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		this.empleado.setTicket(ticket);
		Assert.assertEquals(ticket, this.empleado.getTicket());
	}
}
