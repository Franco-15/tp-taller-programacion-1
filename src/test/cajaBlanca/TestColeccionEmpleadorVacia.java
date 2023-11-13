package test.cajaBlanca;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;

public class TestColeccionEmpleadorVacia {
	private UtilPromo utilPromo=new UtilPromo();
	private HashMap<String, EmpleadoPretenso> empleados=new HashMap<>();
	private HashMap<String, Empleador> empleadores=new HashMap<>();
	public EmpleadoPretenso empleado;
	
	
	@Before
	public	void setup() {
		empleado =new EmpleadoPretenso();
		empleados.put("Manuel", empleado);
	}
	
 	/*  promoPorListaDePostulantes==False;
		empleado.size()==1 
		empleadores.size()==0;
	 */
	@Test
	public void testC3() {
		assertEquals("El metodo retorna el unico empleado",empleado,utilPromo.aplicaPromo(false, empleados, empleadores));
	}
	
	/*	promoPorListaDePostulantes==False;
		empleado.size()==1 
		empleadores.size()==0;
		empleado.puntaje==MIN_VALUE
	 */
	@Test
	public void testC4() {
		empleado.setPuntaje(Integer.MIN_VALUE);
		assertEquals("El metodo retorna el unico empleado",null,utilPromo.aplicaPromo(false, empleados, empleadores));
	}
	
	/*	promoPorListaDePostulantes==true;
	empleadores.size()==0;
	empleados.size()==1;
	La lista del empleador debe ser == null
 * 
 */
@Test
public void testC8() {
	assertEquals("El metodo retorna el empleado",empleado,this.utilPromo.aplicaPromo(true, empleados, empleadores));
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
	ArrayList <ClientePuntaje> listaPostulantes = new ArrayList<>();
	listaPostulantes.add(CP);
	empleado.setListaDePostulantes(listaPostulantes);
	assertEquals("El metodo retorna empleado",empleado,utilPromo.aplicaPromo(true, empleados, empleadores));
	}

}
