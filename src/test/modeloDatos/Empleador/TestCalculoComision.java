package test.modeloDatos.Empleador;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;
import modeloDatos.Empleador;
import modeloDatos.Ticket;

public class TestCalculoComision {
	
	private Empleador empleador;
	@Before
	public void setUp() throws Exception {
		empleador = new Empleador();
	}

	@Test
    public void testCalculaComisionSalud(){
         empleador.setRubro(Constantes.SALUD);
         Ticket ticket = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR, Constantes.EXP_MEDIA,Constantes.TERCIARIOS);
         double esperado = empleador.calculaComision(ticket);
         Assert.assertEquals("La comision no ha sido calculada correctamente",60000, esperado,0);
    }
	
	@Test
    public void testCalculaComisionLocal(){
         empleador.setRubro(Constantes.COMERCIO_LOCAL);
         Ticket ticket = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR, Constantes.EXP_MEDIA,Constantes.TERCIARIOS);
         double esperado = empleador.calculaComision(ticket);
         Assert.assertEquals("La comision no ha sido calculada correctamente",70000, esperado,0);
    }
	
	@Test
    public void testCalculaComisionInternacional(){
         empleador.setRubro(Constantes.COMERCIO_INTERNACIONAL);
         Ticket ticket = new Ticket(Constantes.PRESENCIAL,100000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR, Constantes.EXP_MEDIA,Constantes.TERCIARIOS);
         double esperado = empleador.calculaComision(ticket);
         Assert.assertEquals("La comision no ha sido calculada correctamente",80000, esperado,0);
    }

}
