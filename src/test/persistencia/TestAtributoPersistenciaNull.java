package test.persistencia;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloNegocio.Agencia;
import persistencia.PersistenciaXML;

public class TestAtributoPersistenciaNull {

	private Agencia agencia = Agencia.getInstance();
	private String nombre_archivo = "Agencia.xml";

	@Before
	public void setUp() throws Exception {
		File archivo = new File(nombre_archivo);			
		if(archivo.exists())
			archivo.delete();
	}
	
	@After
	public void tearDown() throws Exception {
		File archivo = new File(nombre_archivo);
		agencia.setPersistencia(null);
		if(archivo.exists())
			archivo.delete();
	}
	
	@Test
	public void test_crear_archivo() {
		try {
			File archivo = new File(nombre_archivo);			
			agencia.guardarAgencia(nombre_archivo);
			Assert.assertFalse("No se deberia poder persistir la agencia" + nombre_archivo, archivo.exists());
		} catch (IOException e) {
			Assert.fail("No deberia lanzar una excepcion");
		}
	}
	
	@Test
	public void test_cargar_archivo() {
		try {
			File archivo = new File(nombre_archivo);			
			Assert.assertFalse("No se deberia poder cargar la agencia", agencia.cargarAgencia(nombre_archivo));
		} catch (IOException e) {
			Assert.fail("No se deberia lanzar una IOException");
		} catch (ClassNotFoundException e) {
			Assert.fail("No se deberia lanzar la excepcion ClassNotFoundException");
		}
	}
}
