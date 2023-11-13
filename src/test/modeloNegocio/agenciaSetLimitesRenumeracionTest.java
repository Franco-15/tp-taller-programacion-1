package test.modeloNegocio;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloNegocio.Agencia;

public class agenciaSetLimitesRenumeracionTest {

	
	Agencia agencia = Agencia.getInstance();
	

	
	@Test(expected = LimiteInferiorRemuneracionInvalidaException.class)
	public void testLimiteInferiorInvalido() throws LimiteSuperiorRemuneracionInvalidaException, LimiteInferiorRemuneracionInvalidaException {
		agencia.setLimitesRemuneracion(-5, 100);
	}

	@Test(expected = LimiteSuperiorRemuneracionInvalidaException.class)
	public void testLimiteSuperiorInvalido() throws LimiteSuperiorRemuneracionInvalidaException, LimiteInferiorRemuneracionInvalidaException{
		agencia.setLimitesRemuneracion(100, 50);
	}
	
	@Test
	public void testLimitesCorectos() {
		//expect limites = 100, 150
		try {
		agencia.setLimitesRemuneracion(100, 150);
		Assert.assertEquals("Limite Inferior no setteado correctamente", 100, agencia.getLimiteInferior());
		Assert.assertEquals("Limite Superior no setteado correctamente", 150, agencia.getLimiteSuperior());
		}catch(Exception exp) {}
	}
}
