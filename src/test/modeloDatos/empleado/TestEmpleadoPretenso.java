package test.modeloDatos.empleado;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;

public class TestEmpleadoPretenso {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_constructor_params_no_vacios() {
		
		try {
			EmpleadoPretenso empleado = new EmpleadoPretenso("Messi10", "1234", "jose", "22344441111", "rodriguez", 50);
		
			Assert.assertEquals("El nombre de usuario no coincide", "Messi10", empleado.getUsserName());
			Assert.assertEquals("El nombre de usuario no coincide", "1234", empleado.getPassword());
			Assert.assertEquals("El nombre de usuario no coincide", "jose", empleado.getRealName());
			Assert.assertEquals("El nombre de usuario no coincide", "22344441111", empleado.getTelefono());
			Assert.assertEquals("El nombre de usuario no coincide", "rodriguez", empleado.getApellido());
			Assert.assertEquals("El nombre de usuario no coincide", 50, empleado.getEdad());
		}catch (Exception e) {
			fail("No deberia lanzarse una excepcion");
		}
	}
	
	@Test
	public void test_constructor_params_vacios() {
		
		try {
			EmpleadoPretenso empleado = new EmpleadoPretenso("", "", "", "", "", 1);
		
			Assert.assertEquals("El nombre de usuario no coincide", "", empleado.getUsserName());
			Assert.assertEquals("El nombre de usuario no coincide", "", empleado.getPassword());
			Assert.assertEquals("El nombre de usuario no coincide", "", empleado.getRealName());
			Assert.assertEquals("El nombre de usuario no coincide", "", empleado.getTelefono());
			Assert.assertEquals("El nombre de usuario no coincide", "", empleado.getApellido());
			Assert.assertEquals("El nombre de usuario no coincide", 1, empleado.getEdad());
		}catch (Exception e) {
			fail("No deberia lanzarse una excepcion");
		}
	}

}
