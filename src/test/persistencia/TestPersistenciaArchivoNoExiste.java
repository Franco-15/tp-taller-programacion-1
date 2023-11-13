package test.persistencia;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloNegocio.Agencia;
import persistencia.PersistenciaXML;

public class TestPersistenciaArchivoNoExiste {

	private Agencia agencia = Agencia.getInstance();
	private String nombre_archivo = "Agencia.xml";

	@Before
	public void setUp() throws Exception {
		agencia.setPersistencia(new PersistenciaXML());
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
			Assert.assertTrue("Deberia existir el archivo " + nombre_archivo, archivo.exists());
		} catch (IOException e) {
			Assert.fail("No deberia lanzar una excepcion");
		}
	}
	
	@Test
	public void test_cargar_archivo() {
		try {
			File archivo = new File(nombre_archivo);			
			agencia.cargarAgencia(nombre_archivo);
			Assert.fail("No deberia continuar con la ejecucion del codigo");
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			Assert.fail("No deberia lanzar la excepcion ClassNotFoundException");
		}
	}
}
