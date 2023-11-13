package test.modeloNegocio;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloNegocio.Agencia;
import util.Constantes;

public class agenciaMatchTest {
	private static Agencia agencia;
	private static Cliente empleado;
	private static Cliente empleador;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		agencia = Agencia.getInstance();
		
		empleado = agencia.registroEmpleado(
			"a", //usuario
			"aa",//pass
			"aaa",//nombre
			"aaaa",//apellido
		    "12345",//telefono
			20
		);
		
		empleador = agencia.registroEmpleador(
			"b", 
			"bb", 
			"bbb", 
			"12345", 
			Constantes.JURIDICA, 
			Constantes.SALUD
		);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@AfterClass
	public static void tearDown() {
		agencia.getEmpleados().clear();
		agencia.getEmpleadores().clear();

	}


}
