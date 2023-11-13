package test.modeloNegocio;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import excepciones.ImposibleCrearEmpleadoException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.NewRegisterException;
import modeloDatos.Cliente;
import modeloNegocio.Agencia;
import util.Constantes;

public class agenciaRegistroTest {
	private static Agencia agencia = Agencia.getInstance();
	@BeforeClass
	public static void setUp() throws Exception {
		
		Cliente empleado  = agencia.registroEmpleado("a", "aa", "aaa", "aaaa", "1234567", 28);
		Cliente empleador = agencia.registroEmpleador("d", "dd", "ddd", "1234567", Constantes.JURIDICA, Constantes.SALUD);

	}
	
	@AfterClass
	public static void tearDown() {
		agencia.getEmpleados().clear();
	}

	
	@Test(expected = NewRegisterException.class)
	public void testRegistrarEmpleadoYaExistente() throws NewRegisterException, ImposibleCrearEmpleadoException {
		//expected new usuario exception
		Cliente empleado = agencia.registroEmpleado("a", "aaaa", "awefawef", "Asfawef","234235", 50);
	}
	
	@Test
	public void testRegistrarEmpleadoCorrecto() throws NewRegisterException, ImposibleCrearEmpleadoException {
		//expected cliente con datos correctos.
		Cliente empleado = agencia.registroEmpleado("b", "bb", "bbb", "bbbb","12345", 50);
		Assert.assertEquals("Nombre de usuario incorrecto", "b", empleado.getUsserName());
		Assert.assertEquals("Contraseña incorrecta", "bb", empleado.getPassword());
		Assert.assertEquals("Nombre real incorrecto", "bbb", empleado.getRealName());
		Assert.assertEquals("Telefono incorrecto", "12345", empleado.getTelefono());
	}
	
	@Test(expected = ImposibleCrearEmpleadoException.class)
	public void testRegistrarEmpleadoIncorrecto() throws NewRegisterException, ImposibleCrearEmpleadoException {
		//expected imposible crear usuario exception
		Cliente empleado = agencia.registroEmpleado("c", null, "awefawef", "Asfawef","234235", 50);
	}
	

	@Test(expected = NewRegisterException.class)
	public void testRegistrarEmpleadorYaExistente() throws NewRegisterException, ImposibleCrearEmpleadorException {
		//expected new usuario exception
		Cliente empleador = agencia.registroEmpleador("d", "dd", "ddd", "1234567", Constantes.JURIDICA, Constantes.SALUD);
	}
	
	@Test
	public void testRegistrarEmpleadorCorrecto() throws NewRegisterException, ImposibleCrearEmpleadorException {
		//expected cliente con datos correctos.
		Cliente empleador  = agencia.registroEmpleador("e", "ee", "eee", "234523462", Constantes.JURIDICA, Constantes.SALUD);
		Assert.assertEquals("Nombre de usuario incorrecto", "e", empleador.getUsserName());
		Assert.assertEquals("Contraseña incorrecta", "ee", empleador.getPassword());
		Assert.assertEquals("Nombre real incorrecto", "eee", empleador.getRealName());
		Assert.assertEquals("Telefono incorrecto", "234523462", empleador.getTelefono());
	}
	
	@Test(expected = ImposibleCrearEmpleadorException.class)
	public void testRegistrarEmpleadorIncorrecto() throws NewRegisterException, ImposibleCrearEmpleadorException {
		agencia.registroEmpleador("f", null, "dddd", null, Constantes.JURIDICA, Constantes.SALUD);
	}
}
