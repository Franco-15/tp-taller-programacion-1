package test.modeloDatos.Empleador;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Constantes;
import org.junit.Assert;
import modeloDatos.Empleador;


public class TestEmpleador {

	@Test
    public void testConstructorEmpleadorNoVacio(){
        Empleador empleador = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        Assert.assertEquals("El usserName no ha sido registrado correctamente","nombre1", empleador.getUsserName());
        Assert.assertEquals("La contraseña no ha sido registrada correctamente","contraseña1", empleador.getPassword());
        Assert.assertEquals("El nombre real no ha sido registrado correctamente","nombrereal1", empleador.getRealName());
        Assert.assertEquals("El telefono no ha sido registrado correctamente","12345678", empleador.getTelefono());
        Assert.assertEquals("El rubro no ha sido registrado correctamente",Constantes.SALUD, empleador.getRubro());
        Assert.assertEquals("El tipo de persona no ha sido registrado correctamente",Constantes.FISICA, empleador.getTipoPersona());
    }

    @Test
    public void testConstructorEmpleadorVacio(){
        Empleador empleador = new Empleador("","","","",Constantes.COMERCIO_LOCAL,Constantes.JURIDICA);
        Assert.assertEquals("El usserName no ha sido registrado correctamente","", empleador.getUsserName());
        Assert.assertEquals("La contraseña no ha sido registrada correctamente","", empleador.getPassword());
        Assert.assertEquals("El nombre real no ha sido registrado correctamente","", empleador.getRealName());
        Assert.assertEquals("El telefono no ha sido registrado correctamente","", empleador.getTelefono());
        Assert.assertEquals("El rubro no ha sido registrado correctamente",Constantes.COMERCIO_LOCAL, empleador.getRubro());
        Assert.assertEquals("El tipo de persona no ha sido registrado correctamente",Constantes.JURIDICA, empleador.getTipoPersona());
    }
    
    @Test
    public void testSetTipoPersonaNoVacio(){
        Empleador empleador = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        empleador.setTipoPersona(Constantes.JURIDICA);
        Assert.assertEquals("El tipo de persona no ha sido registrado correctamente",Constantes.JURIDICA, empleador.getTipoPersona());
    }
    
    @Test
    public void testSetTipoPersonaVacio(){
        Empleador empleador = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        empleador.setTipoPersona("");
        Assert.assertEquals("El tipo de persona no ha sido registrado correctamente","", empleador.getTipoPersona());
    }

    @Test
    public void testSetRubroNoVacio(){
        Empleador empleador = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        empleador.setRubro(Constantes.COMERCIO_LOCAL);
        Assert.assertEquals("El rubro no ha sido registrado correctamente",Constantes.COMERCIO_LOCAL, empleador.getRubro());
    }
    
    @Test
    public void testSetRubroVacio(){
        Empleador empleador = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        empleador.setRubro("");
        Assert.assertEquals("El rubro no ha sido registrado correctamente","", empleador.getRubro());
    }

}