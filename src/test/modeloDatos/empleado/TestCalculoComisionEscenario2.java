package test.modeloDatos.empleado;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Ticket;
import util.Constantes;

public class TestCalculoComisionEscenario2 {

	private EmpleadoPretenso empleado;
	@Before
	public void setUp() {
		empleado = new EmpleadoPretenso();
		empleado.setPuntaje(-1);
	}

	@Test
	public void test_comision_puesto_junior() {
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		double comision = this.empleado.calculaComision(ticket);
		Assert.assertEquals(16000, comision, 0);
	}
	
	@Test
	public void test_comision_puesto_senior() {
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.SENIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		double comision = this.empleado.calculaComision(ticket); 
		Assert.assertEquals(18000.0, comision, 0);
	}
	
	@Test
	public void test_comision_puesto_managment() {
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.MANAGMENT, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		double comision = this.empleado.calculaComision(ticket); 
		Assert.assertEquals(20000.0, comision, 0);
	}
}
