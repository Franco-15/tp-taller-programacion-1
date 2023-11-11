package testGui.testGUIPanelLogin;

import controlador.Controlador;
import testGui.TestUtils;
import vista.Ventana;
import java.awt.AWTException;
import java.awt.Robot;
import javax.swing.JButton;
import javax.swing.JTextField;
import util.Constantes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestPanelLogin {
    Robot robot;
    Controlador controlador;

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
    }
    
    @After
    public void tearDown() throws Exception
    {
        Ventana ventana = (Ventana) controlador.getVista();
        ventana.setVisible(false);
    }


    @Test
    public void testRegSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.NOMBRE_USUARIO);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("holajfgjfgjfgjfgjfgjfgjfgjfgjfgjfgjgfjfgjfgjfgjfgjfgj", robot);
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarLog.isEnabled());
    }
}