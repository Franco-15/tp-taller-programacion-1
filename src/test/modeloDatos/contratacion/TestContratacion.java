package test.modeloDatos.contratacion;


import org.junit.Test;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;
import org.junit.Assert;

public class TestContratacion {

	 @Test
	    public void testConstructorContratacion(){
	        Empleador empleador = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
	        EmpleadoPretenso empleado = new EmpleadoPretenso("nombre2","contraseña2","nombrereal2","22345678","apellido",20);
	        Contratacion contratacion = new Contratacion(empleador,empleado);
	        Assert.assertEquals("El empleador no ha sido registrado correctamente",empleador,contratacion.getEmpleador());
	        Assert.assertEquals("El empleado no ha sido registrado correctamente",empleado,contratacion.getEmpleado());
	    }

	    @Test
	    public void testSetEmpleador(){
	        Empleador empleador = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
	        EmpleadoPretenso empleado = new EmpleadoPretenso("nombre2","contraseña2","nombrereal2","22345678","apellido",20);
	        Contratacion contratacion = new Contratacion(empleador,empleado);
	        Empleador empleador2 = new Empleador("nombre3","contraseña3","nombrereal3","32345678",Constantes.SALUD,Constantes.FISICA);
	        contratacion.setEmpleador(empleador2);
	        Assert.assertEquals("El empleador no ha sido registrado correctamente",empleador2,contratacion.getEmpleador());
	    }

	    @Test
	    public void testSetEmpleado(){
	        Empleador empleador = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
	        EmpleadoPretenso empleado = new EmpleadoPretenso("nombre2","contraseña2","nombrereal2","22345678","apellido",20);
	        Contratacion contratacion = new Contratacion(empleador,empleado);
	        EmpleadoPretenso empleado2 = new EmpleadoPretenso("nombre3","contraseña3","nombrereal3","32345678","apellido",30);
	        contratacion.setEmpleado(empleado2);
	        Assert.assertEquals("El empleado no ha sido registrado correctamente",empleado2,contratacion.getEmpleado());
	    }
}
