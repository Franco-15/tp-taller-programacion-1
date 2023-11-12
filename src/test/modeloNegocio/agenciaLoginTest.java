package test.modeloNegocio;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.Cliente;
import modeloDatos.Usuario;
import modeloNegocio.Agencia;
import util.Constantes;

public class agenciaLoginTest {

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

	@Test(expected = NombreUsuarioException.class)
	public void testLoginUsuarioInexistente() throws Exception {
		agencia.login("inexistente", "1234");
	}
	
	@Test(expected = ContraException.class)
	public void testLoginContraseñaIncorrecta() throws Exception {
		agencia.login("a", "1234");
	}
	
	@Test
	public void testLoginEmpleado() throws Exception {
		Usuario empleado = agencia.login("a", "aa");
		
		Assert.assertEquals("Tipo de usuario incorrecto.", 0, agencia.getTipoUsuario());
		Assert.assertEquals("Nombre de usuario incorrecto", "a", empleado.getUsserName());
		Assert.assertEquals("Contraseña incorrecta", "aa", empleado.getPassword());
		Assert.assertEquals("Nombre real incorrecto", "aaa", empleado.getRealName());
		Assert.assertEquals("Telefono incorrecto", "12345", empleado.getTelefono());
	}
	
	@Test
	public void testLoginEmpleador()  throws Exception{
		Usuario empleado = agencia.login("b", "bb");
		Assert.assertEquals("Tipo de usuario incorrecto.", 1, agencia.getTipoUsuario());
		Assert.assertEquals("Nombre de usuario incorrecto", "b", empleado.getUsserName());
		Assert.assertEquals("Contraseña incorrecta", "bb", empleado.getPassword());
		Assert.assertEquals("Nombre real incorrecto", "bbb", empleado.getRealName());
		Assert.assertEquals("Telefono incorrecto", "12345", empleado.getTelefono());
	}

}
