package test.testGui.testGUIPanelLogin;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloNegocio.Agencia;
import test.testGui.FalseOptionPane;
import test.testGui.TestUtils;
import util.Constantes;
import util.Mensajes;
import vista.Ventana;

public class TestPanelLogin {

	Robot robot;
    Controlador controlador;
    Agencia agencia;
    FalseOptionPane op = new FalseOptionPane();
    public TestPanelLogin()
    {
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
        }
    }

    @Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
        controlador.setMyOptionPane(op);
        agencia = Agencia.getInstance();
        agencia.registroEmpleado("nombre1","contra1","22345678","nombrereal1","apellido",20);
    }
    
    @After
	public void tearDown() throws Exception {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
        agencia.getEmpleados().clear();
	}

    @Test
    public void testLoginCorrecto(){
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.NOMBRE_USUARIO);
        JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.PASSWORD);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("nombre1", robot);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("contra1", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        TestUtils.getDelay();
        JButton cerrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.CERRARSESION);
        Assert.assertNotNull("No se hizo el login correctamente",cerrar);
    }

     @Test
    public void testContraIncorrectaException(){
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.NOMBRE_USUARIO);
        JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.PASSWORD);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("nombre1", robot);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("contra2", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        TestUtils.getDelay();
        Assert.assertEquals("Los mensajes de respuesta no coinciden",Mensajes.PASS_ERRONEO.getValor(),op.getMensaje());
    }

    @Test
    public void testUsuarioDesconocidoException(){
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.NOMBRE_USUARIO);
        JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.PASSWORD);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("nombre2", robot);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("contra1", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        TestUtils.getDelay();
        Assert.assertEquals("Los mensajes de respuesta no coinciden",Mensajes.USUARIO_DESCONOCIDO.getValor(),op.getMensaje());
    }
}