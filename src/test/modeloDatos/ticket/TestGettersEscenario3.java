package test.modeloDatos.ticket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestGettersEscenario3 {
	private Agencia agencia = Agencia.getInstance();
	private Ticket ticketEmpledor;
	
	@Before
	public void setUp(){
		try {
			agencia.setLimitesRemuneracion(20000, 80000);
			ticketEmpledor = new Ticket(Constantes.INDISTINTO, 10000, Constantes.JORNADA_EXTENDIDA, Constantes.MANAGMENT, Constantes.EXP_MUCHA, Constantes.TERCIARIOS);
		} catch (LimiteSuperiorRemuneracionInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LimiteInferiorRemuneracionInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}
	
	@Test
	public void test_get_comparacion_estudios_primarios() {		
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(-2, ticketEmpledor.getComparacionEstudios(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_estudios_secundario() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.SECUNDARIOS);
		Assert.assertEquals(-1.5, ticketEmpledor.getComparacionEstudios(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_estudios_terciario() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.TERCIARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionEstudios(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_experiencia_nada() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(-2, ticketEmpledor.getComparacionExperiencia(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_experiencia_media() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		Assert.assertEquals(-1.5, ticketEmpledor.getComparacionExperiencia(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_experiencia_mucha() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_MUCHA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionExperiencia(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_jornada_media() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(-1, ticketEmpledor.getComparacionJornada(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_jornada_completa() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionJornada(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_jornada_extendida() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_EXTENDIDA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionJornada(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_locacion_home_office() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionLocacion(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_locacion_presencial() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.PRESENCIAL, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(-1, ticketEmpledor.getComparacionLocacion(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_locacion_indistinto() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.INDISTINTO, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionLocacion(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_puesto_junior() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(-1, ticketEmpledor.getComparacionPuesto(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_puesto_senior() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionPuesto(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_puesto_managment() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_MEDIA, Constantes.MANAGMENT, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionPuesto(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_remuneracion_hasta_v1() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 10000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionRemuneracion(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_remuneracion_entre_v1_v2() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 40000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionRemuneracion(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_puesto_remuneracion_mas_v2() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 100000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(1, ticketEmpledor.getComparacionRemuneracion(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_total_1() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.HOME_OFFICE, 10000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.PRIMARIOS);
		Assert.assertEquals(-4, ticketEmpledor.getComparacionTotal(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_total_2() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.PRESENCIAL, 40000, Constantes.JORNADA_COMPLETA, Constantes.SENIOR, Constantes.EXP_MEDIA, Constantes.SECUNDARIOS);
		Assert.assertEquals(-1, ticketEmpledor.getComparacionTotal(ticketEmpledoPretenso), 0); 
	}
	
	@Test
	public void test_get_comparacion_total_3() {
		Ticket ticketEmpledoPretenso = new Ticket(Constantes.INDISTINTO, 100000, Constantes.JORNADA_EXTENDIDA, Constantes.MANAGMENT, Constantes.EXP_MUCHA, Constantes.TERCIARIOS);
		Assert.assertEquals(6, ticketEmpledor.getComparacionTotal(ticketEmpledoPretenso), 0); 
	}
	
}
