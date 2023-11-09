package cajaBlanca;


import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestColeccionEmpleadorVacia {
	private UtilPromo utilPromo=new UtilPromo();;
	private HashMap<String, EmpleadoPretenso> empleados=new HashMap<>();
	private HashMap<String, Empleador> empleadores=new HashMap<>();
	public EmpleadoPretenso empleado;
	
	
	@Before
 public	void setup() {
		this.empleado =new EmpleadoPretenso("ManuelDeserti","Manu123","Manuel","123123","Deserti",23);
		empleados.put("Manuel", empleado);
		 System.out.println("HashMap después de agregar elementos: " + empleado);
	}
	/*
 	*  promoPorListaDePostulantes==False;
		empleado.size()==1 
		empleadores.size()==0;
	 */
	@Test
	public void testC3() {
		assertEquals("El metodo retorna null",empleado,utilPromo.aplicaPromo(false, empleados, empleadores));
	}
	/*	promoPorListaDePostulantes==true;
	empleadores.size()==0;
	empleados.size()==1;
	La lista del empleador debe ser == null
 * 
 */
@Test
public void testC8() {
	assertEquals("El metodo retorna null",empleado,utilPromo.aplicaPromo(true, empleados, empleadores));
}
/*
 * 	promoPorListaDePostulantes==true;
	empleadores.size()==0;
	empleados.size()==1;
	La lista del empleado debe contener un elemento
	
	
 */
@Test
public void testC9() {
	Empleador empleador =new Empleador();
	ClientePuntaje CP=new ClientePuntaje();
	empleador.setPuntaje(10);
	CP.setCliente(empleador);
	empleado.getListaDePostulantes().add(CP);
	assertEquals("El metodo retorna null",empleado,utilPromo.aplicaPromo(true, empleados, empleadores));
}
}
