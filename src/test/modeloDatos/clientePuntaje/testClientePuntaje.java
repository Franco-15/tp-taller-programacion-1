package test.modeloDatos.clientePuntaje;

import org.junit.Assert;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;
import modeloDatos.Cliente;

public class testClientePuntaje {

	@Test
    public void testConstructorClientePuntajePositivo() {
        Cliente cliente = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        ClientePuntaje cp = new ClientePuntaje(1,cliente);
        double puntaje = cp.getPuntaje();
        Assert.assertEquals("El puntaje no ha sido registrado correctamente",1,puntaje,0);
        Assert.assertEquals("El cliente no ha sido registrado correctamente",cliente,cp.getCliente());
    }

    @Test
    public void testConstructorClientePuntajeCero() {
        Cliente cliente = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        ClientePuntaje cp = new ClientePuntaje(0,cliente);
        double puntaje = cp.getPuntaje();
        Assert.assertEquals("El puntaje no ha sido registrado correctamente",0,puntaje,0);
        Assert.assertEquals("El cliente no ha sido registrado correctamente",cliente,cp.getCliente());
    }

    @Test
    public void testConstructorClientePuntajeNegativo() {
        Cliente cliente =  new EmpleadoPretenso("nombre2","contraseña2","nombrereal2","22345678","apellido",20);
        ClientePuntaje cp = new ClientePuntaje(-1,cliente);
        double puntaje = cp.getPuntaje();
        Assert.assertEquals("El puntaje no ha sido registrado correctamente",-1,puntaje,0);
        Assert.assertEquals("El cliente no ha sido registrado correctamente",cliente,cp.getCliente());
    }

    @Test
    public void testSetCliente() {
        Cliente cliente = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        ClientePuntaje cp = new ClientePuntaje(1,cliente);
        Cliente cliente2 =  new EmpleadoPretenso("nombre2","contraseña2","nombrereal2","22345678","apellido",20);
        cp.setCliente(cliente2);
        Assert.assertEquals("El cliente no ha sido registrado correctamente",cliente2,cp.getCliente());
    }

    @Test
    public void testSetPuntaje() {
        Cliente cliente = new Empleador("nombre1","contraseña1","nombrereal1","12345678",Constantes.SALUD,Constantes.FISICA);
        ClientePuntaje cp = new ClientePuntaje(1,cliente);
        cp.setPuntaje(-1);
        Assert.assertEquals("El puntaje no ha sido registrado correctamente",-1,cp.getPuntaje(),0);
    }

}
