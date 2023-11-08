package test.modeloDatos.ticket;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.Ticket;
import util.Constantes;

public class TestTicket {

	@Test
	public void test_constructor_ticket() {
		Ticket ticket = new Ticket(Constantes.HOME_OFFICE, 20000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS);
		Assert.assertEquals("La locacion no coincide con la esperada", Constantes.HOME_OFFICE, ticket.getLocacion());
		Assert.assertEquals("La remuneracion no coincide con la esperada", 20000, ticket.getRemuneracion());
		Assert.assertEquals("La jornada no coincide con la esperada", Constantes.JORNADA_COMPLETA, ticket.getJornada());
		Assert.assertEquals("El puesto no coincide con el esperado", Constantes.JUNIOR, ticket.getPuesto());
		Assert.assertEquals("La experiencia no coincide con la esperada", Constantes.EXP_MEDIA, ticket.getExperiencia());
		Assert.assertEquals("Los estudios no coincide con los esperados", Constantes.PRIMARIOS, ticket.getEstudios());
	}

}
