package test.modeloDatos.empleado;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Ticket;
import util.Constantes;
public class TestCalculoComisionEscenario1 {
	
	private EmpleadoPretenso empleado;
	@Before
	public void setUp() {
		empleado = new EmpleadoPretenso();
		empleado.setPuntaje(1);
	}

	@Test
	public void test_comision_puesto_junior() {
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		double comision = this.empleado.calculaComision(ticket);
		Assert.assertEquals(15800.0, comision, 0);
	}
	
	@Test
	public void test_comision_puesto_senior() {
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.SENIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		double comision = this.empleado.calculaComision(ticket); 
		Assert.assertEquals(17800.0, comision, 0);
	}
	
	@Test
	public void test_comision_puesto_managment() {
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.MANAGMENT, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		double comision = this.empleado.calculaComision(ticket); 
		Assert.assertEquals(19800.0, comision, 0);
	}
}
