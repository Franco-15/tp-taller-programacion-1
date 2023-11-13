package test.cajaBlanca;
import static org.junit.Assert.assertEquals;


import java.util.HashMap;

import org.junit.Test;

import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;

public class TestColeccionesVacias {
	private UtilPromo utilPromo=new UtilPromo();;
	private HashMap<String, EmpleadoPretenso> empleados=new HashMap<>();
	private HashMap<String, Empleador> empleadores=new HashMap<>();
	
	/*	promoPorListaDePostulantes==False;
	empleadores.size()==0;
	empleados.size()==0; 
 	*/

@Test
public void testC1() {
	assertEquals("El metodo retorna null",null,utilPromo.aplicaPromo(false, empleados, empleadores));
}

/*	promoPorListaDePostulantes==true;
empleadores.size()==0;
empleados.size()==0;
*/
	
@Test
public void testC5() {
UtilPromo utilPromo=new UtilPromo();
 
assertEquals("El metodo retorna null",null,utilPromo.aplicaPromo(true, empleados, empleadores));
}

}
