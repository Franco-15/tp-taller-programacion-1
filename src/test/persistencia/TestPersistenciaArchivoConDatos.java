package test.persistencia;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import persistencia.PersistenciaXML;

public class TestPersistenciaArchivoConDatos {

	private Agencia agencia = Agencia.getInstance();
	private String nombre_archivo = "AgenciaConDatos.xml";

	@Before
	public void setUp() throws Exception {
		agencia.setPersistencia(new PersistenciaXML());
	}

	@After
	public void tearDown() {
		agencia.setPersistencia(null);	
	}
	@Test
	public void test_cargar_archivo() {
		File archivo = new File(nombre_archivo);			
		try {
			agencia.cargarAgencia(nombre_archivo);
			EmpleadoPretenso empleado = agencia.getEmpleados().get("messias");
			Empleador empleador = agencia.getEmpleadores().get("Diegote");
			Assert.assertTrue(nombre_archivo, agencia.getEmpleados().size() == 1);
			Assert.assertTrue(nombre_archivo, agencia.getEmpleadores().size() == 1);
			Assert.assertTrue(nombre_archivo, empleado.getTicket()!= null);
			Assert.assertTrue(nombre_archivo, empleador.getTicket()!= null);
		} catch (ClassNotFoundException | IOException e) {
			Assert.fail("No deberia lanzarse una excepcion");
		}
	}
}
