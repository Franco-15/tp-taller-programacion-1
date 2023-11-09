package cajaBlanca;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;

public class TestColeccionEmpleadosVacia {
	private UtilPromo utilPromo;
	private HashMap<String, EmpleadoPretenso> empleados=new HashMap<>();
	private HashMap<String, Empleador> empleadores=new HashMap<>();
	private Cliente empleador;
	
	@Before 
	 public void setup() {
		 utilPromo=new UtilPromo();
		Empleador empleador =new Empleador();
		empleador.setRealName("Manuel");	
		empleadores.put(null, empleador);
	}
	
	/*	promoPorListaDePostulantes==true;
	empleadores.size()==1;
	La lista del empleador debe ser==null
	empleados.size() == 0;
	*/

	@Test
	public void testC6() {
		empleador.setListaDePostulantes(null);
		utilPromo.aplicaPromo(true, empleados, empleadores);
		assertEquals("El metodo retorna null",empleador,utilPromo.aplicaPromo(true, empleados, empleadores));
	}
/*	promoPorListaDePostulantes==true;
	empleadores.size()==1;
	La lista del empleador debe ser con un elemento.
	empleados.size() == 0;
 */
	@Test
	public void testC7() {
		EmpleadoPretenso empleado =new EmpleadoPretenso();
		ClientePuntaje CP=new ClientePuntaje();
		empleado.setPuntaje(10);
		CP.setCliente(empleado);
		empleador.getListaDePostulantes().add(CP);

		assertEquals("El metodo retorna null",empleador,utilPromo.aplicaPromo(true, empleados, empleadores));
	}
	



}

